package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.FuneralPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FuneralPlanData extends JpaRepository<FuneralPlan, Long> {

    List<FuneralPlan> findByPagoEsseMesAndDataPagamentoBefore(String pagoEsseMes, LocalDate data);
}

