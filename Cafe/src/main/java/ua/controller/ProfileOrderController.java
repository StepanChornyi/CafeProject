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

import ua.model.request.OrderRequest;
import ua.model.request.TableRequest;
import ua.service.OrderService;
import ua.service.TableService;

@Controller
@RequestMapping("/profile/cafe/{cafeId}")
@SessionAttributes("order")
public class ProfileOrderController {

  private final OrderService service;
  
  @Autowired
  public ProfileOrderController(OrderService service) {
    this.service = service;
  }
  
  @ModelAttribute("order")
  public OrderRequest getForm() {
    return new OrderRequest();
  }
  
  @GetMapping("/orders")
  public String show(Model model, @PathVariable Integer cafeId) {
	//model.addAttribute("orders", service.findAllOrdersByCafeId(cafeId));
    model.addAttribute("cafeId", cafeId);
    return "order";
  }
  
  @GetMapping("/addorder")
  public String addOrderShow(Model model, @PathVariable Integer cafeId) {
	//model.addAttribute("tables", service.findAllFreeTablesByCafeId(cafeId));
	//model.addAttribute("meals", service.findAllMealsByCafeId(cafeId));
    model.addAttribute("cafeId", cafeId);
    return "addorder";
  }
  /*
  @PostMapping("/addorder")
  public String saveOrderShow(@ModelAttribute("order") OrderRequest request, @PathVariable Integer cafeId, Model model) {
	service.saveNew(request);
    model.addAttribute("cafeId", cafeId);
    return "redirect:/profile/cafe/{cafeId}";
  }*/
  
  /*
  @GetMapping("/profile/cafe/addtable/{cafeId}/delete/{tableId}")
  public String delete(@PathVariable Integer cafeId,@PathVariable Integer tableId) {
    service.delete(tableId);
    return "redirect:/profile/cafe/addtable/{cafeId}";
  }
  
  @PostMapping("/profile/cafe/addtable/{cafeId}")
  public String save(@ModelAttribute("_table") TableRequest request,  SessionStatus status, @PathVariable Integer cafeId) {
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
  public String reserveSave(@ModelAttribute("_table") TableRequest request, @PathVariable Integer tableId, Model model, SessionStatus status) {
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
  public String reserveSaveU(@ModelAttribute("_table") TableRequest request, @PathVariable Integer tableId, Model model, SessionStatus status) {
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
  */
}