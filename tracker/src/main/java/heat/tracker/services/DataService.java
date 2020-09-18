package heat.tracker.services;

import heat.tracker.models.LocationStats;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.StringReader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@Service
public class DataService {
	private static String DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_US.csv";
	private List<LocationStats> allStats = new ArrayList<>();


	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchData() throws IOException, InterruptedException{
		List<LocationStats> newStats = new ArrayList<>();

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
         .uri(URI.create(DATA_URL))
         .build();
			
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		//System.out.println(httpResponse.body());

		// parsing csv record
		StringReader csvBodyReader = new StringReader(httpResponse.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		for (CSVRecord record : records) {
			// String state = record.get("Province_State");
			// System.out.println(state);
			// String key = record.get("Combined_Key");
			// System.out.println(key);

			LocationStats location = new LocationStats();
			location.setState(record.get("Province_State"));
			location.setCountry(record.get("Country_Region"));
			location.setLatestTotalCases(Integer.parseInt(record.get(record.size() - 1)));

			System.out.println(location);
			newStats.add(location);
		}

		this.allStats = newStats;
	}
}