package company.api.impl;

import company.sample.SampleDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample-data")
public class SampleDataRestController {

    @Autowired
    private SampleDataLoader loader;

    @GetMapping("Load")
    public ResponseEntity<String> loadSampleData() throws Exception {
        loader.LoadSampleData();
        return ResponseEntity.ok("Sample data load successfully");
    }
}
