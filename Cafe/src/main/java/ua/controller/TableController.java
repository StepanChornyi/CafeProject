package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.TableService;

@Controller
@RequestMapping("/cafe/{cafeId}")
public class TableController {

  private final TableService service;
  
  @Autowired
  public TableController(TableService service) {
    this.service = service;
  }
  
  
  
  /*
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
  */
  
  /*
  @GetMapping("/reserve/{tableId}")
  public String reserve(@PathVariable Integer cafeId, @PathVariable Integer tableId, Model model) {
    model.addAttribute("_table", service.findOne(tableId));
    model.addAttribute("cafeId", cafeId);
    return "reserve";
  } 
  
  @PostMapping("/reserve/{tableId}")
  public String reserveSave(@ModelAttribute("_table") TableRequest request, Model model, @PathVariable Integer tableId) {
	service.dereserve(tableId);
    return "redirect:/cafe/{cafeId}/tables";
  }
  */
  /*
  @GetMapping("/addtable/{cafeId}/dereserve/{tableId}")
  public String dereserve(@PathVariable Integer tableId) {
	service.dereserve(tableId);
    return "redirect:/profile/cafe/addtable/{cafeId}";
  } 
  
  */
  
}