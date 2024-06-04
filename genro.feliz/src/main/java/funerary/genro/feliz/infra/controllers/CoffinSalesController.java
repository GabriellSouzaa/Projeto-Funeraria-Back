package funerary.genro.feliz.infra.controllers;


import funerary.genro.feliz.app.models.requests.CoffinSalesRequest;
import funerary.genro.feliz.app.models.responses.CoffinSalesResponse;
import funerary.genro.feliz.app.usecases.CoffinSalesGateway;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Coffin Sales")
@RestController
@RequestMapping("/coffin-sales")
public class CoffinSalesController {

    private final CoffinSalesGateway coffinSalesGateway;


    public CoffinSalesController(CoffinSalesGateway coffinSalesGateway){
        this.coffinSalesGateway = coffinSalesGateway;
    }


    @GetMapping
    ResponseEntity<?> getFindCoffins(){
        List<CoffinSalesResponse> responses = this.coffinSalesGateway.getCoffinsSales();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<?> getCoffin(@PathVariable Long id) {
        CoffinSalesResponse response = this.coffinSalesGateway.getCoffinSales(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/create")
    ResponseEntity<?> createCoffin(@RequestBody CoffinSalesRequest coffinSalesRequestRequest){
        this.coffinSalesGateway.createCoffinSales(coffinSalesRequestRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/update/{id}")
    ResponseEntity<?> updateCoffin(@PathVariable Long id, @RequestBody CoffinSalesRequest coffinSalesRequest){
        this.coffinSalesGateway.updateCoffinSales(id, coffinSalesRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<?> deleteCoffin(@PathVariable Long id){
        this.coffinSalesGateway.deleteCoffinSales(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/report")
    ResponseEntity<?> getReportCoffinSales(){
        return this.coffinSalesGateway.getReportToCoffinSales();
    }
}
