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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Status;
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
	model.addAttribute("orders", service.findAllOrders(cafeId));
	model.addAttribute("accepted", Status.ACCEPTED.toString());
	model.addAttribute("done", Status.DONE.toString());
	model.addAttribute("paid", Status.PAID.toString());
    model.addAttribute("cafeId", cafeId);
    return "order";
  }
  
  @GetMapping("/addorder")
  public String addOrderShow(Model model, @PathVariable Integer cafeId) {
	model.addAttribute("tables", service.findTableByCafeId(cafeId));
	model.addAttribute("meals", service.findMealsByCafeId(cafeId));
    model.addAttribute("cafeId", cafeId);
    return "addorder";
  }
  
  @PostMapping("/addorder")
  public String saveOrderShow(@ModelAttribute("order") @Valid OrderRequest request, BindingResult br, Model model, @PathVariable Integer cafeId, SessionStatus status) {
	  if(br.hasErrors()) return addOrderShow(model, cafeId);
	service.saveNew(request);
	status.setComplete();
    return "redirect:/profile/cafe/{cafeId}/orders";
  }
  
  @GetMapping("/delete/{orderId}")
  public String delete(@PathVariable Integer orderId) {
    service.delete(orderId);
    return "redirect:/profile/cafe/{cafeId}/orders";
  }
  
  @GetMapping("/done/{orderId}")
  public String done(@PathVariable Integer orderId) {
    service.setDone(orderId);
    return "redirect:/profile/cafe/{cafeId}/orders";
  }
  
  @GetMapping("/paid/{orderId}")
  public String paid(@PathVariable Integer orderId) {
    service.setPaid(orderId);
    return "redirect:/profile/cafe/{cafeId}/orders";
  }
  
  @GetMapping("/paidorder")
  public String paidorder(Model model, @PathVariable Integer cafeId) {
	model.addAttribute("orders", service.findPaidOrders(cafeId));
    return "paidorder";
  }
  
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