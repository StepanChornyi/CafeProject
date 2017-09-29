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
  
  @GetMapping("/addtable/{id}")
  public String show(Model model, @PathVariable Integer id) {
    model.addAttribute("tables", service.findTableViewsByCafeId(id));
    model.addAttribute("cafeId", id);
    return "addtable";
  }
  
  
  @GetMapping("/addtable/{id}/delete/{tableId}")
  public String delete(@PathVariable Integer id,@PathVariable Integer tableId) {
    service.delete(tableId);
    return "redirect:/profile/cafe/addtable/{id}";
  }
  
  @PostMapping("/addtable/{id}")
  public String save(@ModelAttribute("_table") TableRequest request,  SessionStatus status, @PathVariable Integer id) {
    request.setIsFree(true);
    request.setCafe(service.findOneCafeById(id));
    service.save(request);
    return cancel(status);
  }
  
  
  @GetMapping("/addtable/{id}/update/{tableId}")
  public String update(@PathVariable Integer id,@PathVariable Integer tableId, Model model) {
    model.addAttribute("_table", service.findOne(tableId));
    model.addAttribute("tables", service.findTableViewsByCafeId(id));
    model.addAttribute("cafeId", id);
    return "addtable";
  } 
  
  @GetMapping("/addtable/{id}/cancel")
  public String cancel(SessionStatus status) {
    status.setComplete();
    return "redirect:/profile/cafe/addtable/{id}";
  }
  
  @GetMapping("/addtable/{id}/reserve/{tableId}")
  public String reserve(@PathVariable Integer id,@PathVariable Integer tableId, Model model) {
    model.addAttribute("_table", service.findOne(tableId));
    model.addAttribute("cafeId", id);
    return "reserve";
  } 
  
  @PostMapping("/addtable/{id}/reserve/{tableId}")
  public String reserveSave(@ModelAttribute("_table") TableRequest request, @PathVariable Integer id, @PathVariable Integer tableId, Model model) {
  request.setId(tableId);
  System.out.println(request.getId());
  service.save(request);
    return "redirect:/profile/cafe/addtable/{id}";
  } 
  
  
}