package com.example.AEM;

import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/performance")
public class PerformanceController {
    private final PerformanceService svc; public PerformanceController(PerformanceService svc){ this.svc=svc; }

    // employee posts a performance entry (unchanged)
    @PostMapping("/add")
    public Performance add(@RequestParam Long empId, @RequestBody Performance p){
        return svc.add(empId,p);
    }

    // employee views their entries (unchanged)
    @GetMapping("/employee/{id}")
    public List<Performance> byEmployee(@PathVariable Long id){
        return svc.listByEmployee(id);
    }

    // manager adds feedback (optionally provide score)
    // Example: POST /api/performance/feedback?perfId=5&score=4
    @PostMapping("/feedback")
    public Performance feedback(@RequestParam Long perfId,
                                @RequestParam String feedback,
                                @RequestParam(required = false) Integer score){
        if (score == null) {
            return svc.addManagerFeedback(perfId, feedback);
        } else {
            return svc.addManagerFeedback(perfId, feedback, score);
        }
    }

    // NEW: manager can list all performances
    @GetMapping("/all")
    public List<Performance> all(){
        return svc.listAll();
    }
}
