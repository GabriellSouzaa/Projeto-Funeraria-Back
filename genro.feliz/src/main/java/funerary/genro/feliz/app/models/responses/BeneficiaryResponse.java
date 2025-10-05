package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.Beneficiary;
import funerary.genro.feliz.domain.Client;
import lombok.Getter;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Getter
public class BeneficiaryResponse {

    private Long id;

    private Long client;

    private String nomeClient;

    private String nomeBeneficiario;

    private String dataNascimento;

    private String adicional;

    private BeneficiaryResponse(Beneficiary beneficiary) {
        this.id = beneficiary.getId();
        this.nomeBeneficiario = beneficiary.getNome();
        this.dataNascimento = formatarDataBR(beneficiary.getDataNascimento());
        this.client = beneficiary.getClient().getId();
        this.nomeClient = beneficiary.getClient().getNome();
        this.adicional = formatarReais(beneficiary.getAdicional());
    }

    public static String formatarReais(float valor) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(valor);
    }
    public static String formatarDataBR(LocalDate data) {
        if (data == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }
    public static BeneficiaryResponse from(Beneficiary beneficiary){ return new BeneficiaryResponse(beneficiary);}
}
