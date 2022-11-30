package com.example.FinalProjectLogbook.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.FinalProjectLogbook.model.Flight;
import com.example.FinalProjectLogbook.model.FlightRepository;
import com.example.FinalProjectLogbook.model.AircraftRepository;

@Controller
public class FlightController {
	@Autowired
	private FlightRepository repository; 
	
	@Autowired
	private AircraftRepository crepo;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
    @RequestMapping(value= {"/", "/flightlist"})
    public String flightList(Model model) {	
        model.addAttribute("flights", repository.findAll());
        return "flightlist";
    }
  
    @RequestMapping(value = "/add")
    public String addFlight(Model model){
    	model.addAttribute("flight", new Flight());
    	model.addAttribute("aircraft", crepo.findAll()); 

    	return "addflight";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Flight flight){
        repository.save(flight);
        return "redirect:flightlist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteFlight(@PathVariable("id") Long flightId, Model model) {
    	repository.deleteById(flightId);
        return "redirect:../flightlist";
    }     
	@RequestMapping(value = "/edit/{id}")
    public String editFlight(@PathVariable("id") Long flightId, Model model){
    	model.addAttribute("flight", repository.findById(flightId));
		model.addAttribute("aircraft", crepo.findAll());
    	return "editflight";
    } 
	@GetMapping("/flights")
	public @ResponseBody List<Flight> flightListRest() {
		return (List<Flight>) repository.findAll();
	}

	@GetMapping("/flights/{id}")
	public @ResponseBody Optional<Flight> findFlightByIdRest(@PathVariable("id") Long flightId) {
		return repository.findById(flightId);
	}
    
}