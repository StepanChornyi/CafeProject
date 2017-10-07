package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.AddTableRequest;
import ua.model.request.TableRequest;
import ua.service.TableService;

@Controller
@SessionAttributes("_table")
public class ProfileTableController {

  private final TableService service;
  
  @Autowired
  public ProfileTableController(TableService service) {
    this.service = service;
  }
  
  @ModelAttribute("_table")
  public TableRequest getForm() {
    return new TableRequest();
  }
  
  @ModelAttribute("addtable")
  public AddTableRequest getAddForm() {
    return new AddTableRequest();
  }
  
  @GetMapping("/profile/cafe/addtable/{cafeId}")
  public String show(Model model, @PathVariable Integer cafeId) {
    model.addAttribute("tables", service.findTableViewsByCafeId(cafeId));
    model.addAttribute("cafeId", cafeId);
    return "addtable";
  }
  
  
  @GetMapping("/profile/cafe/addtable/{cafeId}/delete/{tableId}")
  public String delete(@PathVariable Integer cafeId,@PathVariable Integer tableId) {
    service.delete(tableId);
    return "redirect:/profile/cafe/addtable/{cafeId}";
  }
  
  @PostMapping("/profile/cafe/addtable/{cafeId}")
  public String save(@ModelAttribute("addtable") @Valid AddTableRequest request,BindingResult br, Model model, SessionStatus status, @PathVariable Integer cafeId) {
	  if(br.hasErrors())return show(model, cafeId);
	  TableRequest table = getForm();
	  if(request.getId()!=null){
	  table = service.findOne(request.getId());}
	  table.setCountOfPeople(Integer.valueOf(request.getCountOfPeople()));
	  table.setTableNumber(Integer.valueOf(request.getTableNumber()));
	  service.saveNew(table, cafeId);
    return "redirect:/profile/cafe/addtable/{cafeId}";
  }
  
  
  @GetMapping("/profile/cafe/addtable/{cafeId}/update/{tableId}")
  public String update(Model model, @PathVariable Integer cafeId,@PathVariable Integer tableId) {
    AddTableRequest request = getAddForm();
    TableRequest table = service.findOne(tableId);
    request.setId(tableId);
    request.setCountOfPeople(table.getCountOfPeople().toString());
    request.setTableNumber(table.getTableNumber().toString());
	model.addAttribute("addtable", request);
    return show(model, cafeId);
  } 
  
  @GetMapping("/profile/cafe/addtable/{cafeId}/cancel")
  public String cancel(SessionStatus status) {
    status.setComplete();
    return "redirect:/profile/cafe/addtable/{cafeId}";
  }
  
  @GetMapping("/profile/cafe/addtable/{cafeId}/reserve/{tableId}")
  public String reserve(@PathVariable Integer cafeId, @PathVariable Integer tableId, Model model) {
	    model.addAttribute("cafeId", cafeId);
	    model.addAttribute("tableId", tableId);
	    return "reservation";
	  } 
  
  @PostMapping("/profile/cafe/addtable/{cafeId}/reserve/{tableId}")
  public String reserveSave(@ModelAttribute("_table") @Valid TableRequest request, BindingResult bindingResult, @PathVariable Integer cafeId, @PathVariable Integer tableId, SessionStatus status, Model model) {
	  if(bindingResult.hasErrors())return reserve(cafeId, tableId, model);
	  TableRequest request1 = service.findOne(tableId);
	  request1.setUser(request.getUser());
	  request1.setUserPhone(request.getUserPhone());
	  service.reserve(request1);
	status.setComplete();
    return "redirect:/profile/cafe/addtable/{cafeId}";
  } 
  
  @GetMapping("/profile/cafe/addtable/{cafeId}/dereserve/{tableId}")
  public String dereserve(@PathVariable Integer tableId) {
	service.dereserve(tableId);
    return "redirect:/profile/cafe/addtable/{cafeId}";
  } 
  
  @GetMapping("/cafe/{cafeId}/reserve/{tableId}")
  public String reserveU(@PathVariable Integer cafeId, @PathVariable Integer tableId, Model model) {
    model.addAttribute("cafeId", cafeId);
    model.addAttribute("tableId", tableId);
    return "reserve";
  } 
  
  @PostMapping("/cafe/{cafeId}/reserve/{tableId}")
  public String reserveSaveU(@ModelAttribute("_table") @Valid TableRequest request, BindingResult bindingResult, @PathVariable Integer cafeId, @PathVariable Integer tableId, SessionStatus status, Model model) {
	  if(bindingResult.hasErrors())return reserveU(cafeId, tableId, model);
	  TableRequest request1 = service.findOne(tableId);
	  request1.setUser(request.getUser());
	  request1.setUserPhone(request.getUserPhone());
	  service.reserve(request1);
	status.setComplete();
    return "redirect:/cafe/{cafeId}/tables";
  } 
  
  @GetMapping("/cafe/{cafeId}/tables")
  public String showU(Model model, @PathVariable Integer cafeId) {
    model.addAttribute("tables", service.findFreeTableViewsByCafeId(cafeId));
    model.addAttribute("cafeId", cafeId);
    return "tables";
  }
  
}