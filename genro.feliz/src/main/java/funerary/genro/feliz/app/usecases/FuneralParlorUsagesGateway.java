package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.responses.FuneralParlorResponse;
import funerary.genro.feliz.app.models.responses.FuneralParlorUsagesResponse;
import funerary.genro.feliz.domain.FuneralParlorUsages;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FuneralParlorUsagesGateway {

    List<FuneralParlorUsagesResponse> getFuneralParlorsUsages();

    ResponseEntity<byte[]> getReportFuneralParlosUsages();
}
