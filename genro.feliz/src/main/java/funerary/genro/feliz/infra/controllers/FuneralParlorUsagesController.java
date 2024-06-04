package funerary.genro.feliz.infra.controllers;


import funerary.genro.feliz.app.usecases.FuneralParlorUsagesGateway;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Funeral Parlor")
@RestController
@RequestMapping("/funeral-parlor-usages")
public class FuneralParlorUsagesController {

    private final FuneralParlorUsagesGateway funeralParlorUsagesGateway;

    public FuneralParlorUsagesController(FuneralParlorUsagesGateway funeralParlorUsagesGateway){
        this.funeralParlorUsagesGateway = funeralParlorUsagesGateway;
    }

    @GetMapping(path = "/report")
    ResponseEntity<?> getReportFuneralParlosUsages(){
        return this.funeralParlorUsagesGateway.getReportFuneralParlosUsages();
    }
}
