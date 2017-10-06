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
  public String save(@ModelAttribute("_table") @Valid TableRequest request,BindingResult br, Model model, SessionStatus status, @PathVariable Integer cafeId) {
	  if(br.hasErrors())return show(model, cafeId);
	  service.saveNew(request, cafeId);
    return cancel(status);
  }
  
  
  @GetMapping("/profile/cafe/addtable/{cafeId}/update/{tableId}")
  public String update(Model model,@PathVariable Integer cafeId,@PathVariable Integer tableId) {
    model.addAttribute("_table", service.findOne(tableId));
    return show(model, cafeId);
  } 
  
  @GetMapping("/profile/cafe/addtable/{cafeId}/cancel")
  public String cancel(SessionStatus status) {
    status.setComplete();
    return "redirect:/profile/cafe/addtable/{cafeId}";
  }
  
  @GetMapping("/profile/cafe/addtable/{cafeId}/reserve/{tableId}")
  public String reserve(@PathVariable Integer cafeId, @PathVariable Integer tableId, Model model) {
    model.addAttribute("_table", service.findOne(tableId));
    model.addAttribute("cafeId", cafeId);
    return "reservation";
  } 
  
  @PostMapping("/profile/cafe/addtable/{cafeId}/reserve/{tableId}")
  public String reserveSave(@PathVariable Integer cafeId, @ModelAttribute("_table") @Valid TableRequest request, @PathVariable Integer tableId, Model model, SessionStatus status, BindingResult br) {
	  if(br.hasErrors())return reserve(cafeId, tableId,model);
	  service.reserve(request);
    return cancel(status);
  } 
  
  @GetMapping("/profile/cafe/addtable/{cafeId}/dereserve/{tableId}")
  public String dereserve(@PathVariable Integer tableId) {
	service.dereserve(tableId);
    return "redirect:/profile/cafe/addtable/{cafeId}";
  } 
  
  @GetMapping("/cafe/{cafeId}/reserve/{tableId}")
  public String reserveU(@PathVariable Integer cafeId, @PathVariable Integer tableId, Model model) {
    model.addAttribute("_table", service.findOne(tableId));
    model.addAttribute("cafeId", cafeId);
    return "reserve";
  } 
  
  @PostMapping("/cafe/{cafeId}/reserve/{tableId}")
  public String reserveSaveU(@PathVariable Integer cafeId, @ModelAttribute("_table") @Valid TableRequest request, @PathVariable Integer tableId, BindingResult br, Model model, SessionStatus status) {
	  if(br.hasErrors())return reserveU(cafeId, tableId,model);
	  service.reserve(request);
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