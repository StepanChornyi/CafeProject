package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.TableRequest;
import ua.service.TableService;

@Controller
@RequestMapping("/profile/cafe")
@SessionAttributes("_table")
public class TableController {

  private final TableService service;
  
  @Autowired
  public TableController(TableService service) {
    this.service = service;
  }
  
  @ModelAttribute("_table")
  public TableRequest getForm() {
    return new TableRequest();
  }
  
  @GetMapping("/addtable/{cafeId}")
  public String show(Model model, @PathVariable Integer cafeId) {
    model.addAttribute("tables", service.findTableViewsByCafeId(cafeId));
    model.addAttribute("cafeId", cafeId);
    return "addtable";
  }
  
  
  @GetMapping("/addtable/{cafeId}/delete/{tableId}")
  public String delete(@PathVariable Integer cafeId,@PathVariable Integer tableId) {
    service.delete(tableId);
    return "redirect:/profile/cafe/addtable/{cafeId}";
  }
  
  @PostMapping("/addtable/{cafeId}")
  public String save(@ModelAttribute("_table") TableRequest request,  SessionStatus status, @PathVariable Integer cafeId) {
    service.saveNew(request, cafeId);
    return cancel(status);
  }
  
  
  @GetMapping("/addtable/{cafeId}/update/{tableId}")
  public String update(Model model,@PathVariable Integer cafeId,@PathVariable Integer tableId) {
    model.addAttribute("_table", service.findOne(tableId));
    return show(model, cafeId);
  } 
  
  @GetMapping("/addtable/{cafeId}/cancel")
  public String cancel(SessionStatus status) {
    status.setComplete();
    return "redirect:/profile/cafe/addtable/{cafeId}";
  }
  
  @GetMapping("/addtable/{cafeId}/reserve/{tableId}")
  public String reserve(@PathVariable Integer cafeId,@PathVariable Integer tableId, Model model) {
    model.addAttribute("_table", service.findOne(tableId));
    model.addAttribute("cafeId", cafeId);
    return "reserve";
  } 
  
  @PostMapping("/addtable/{cafeId}/reserve/{tableId}")
  public String reserveSave(@ModelAttribute("_table") TableRequest request, @PathVariable Integer tableId, Model model) {
	service.reserve(request);
    return "redirect:/profile/cafe/addtable/{cafeId}";
  } 
  
  @GetMapping("/addtable/{cafeId}/dereserve/{tableId}")
  public String dereserve(@PathVariable Integer tableId) {
	service.dereserve(tableId);
    return "redirect:/profile/cafe/addtable/{cafeId}";
  } 
  
  
  
}