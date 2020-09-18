package heat.tracker.controllers;

import heat.tracker.models.LocationStats;
import heat.tracker.services.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;

@Controller
public class HomeController {

	@Autowired
	DataService covidData;

	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = covidData.getAllStats();
		int totalReportedCases = allStats.stream().mapToInt(stat->stat.getLatestTotalCases()).sum();	// this just adds all the current allStats together
		int totalNewCases = allStats.stream().mapToInt(stat->stat.getDiffFromPrevDay()).sum();
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalReportedCases);
		model.addAttribute("totalNewCases", totalNewCases);
		return "home";
	}
}