package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.Coffin;
import funerary.genro.feliz.domain.CoffinSales;
import funerary.genro.feliz.domain.Seller;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CoffinSalesResponse {


    private Long id;

    private String nomeVendedor;

    private String modeloCaixao;

    private LocalDate dataVenda;

    public CoffinSalesResponse(CoffinSales coffinSales, Coffin coffin, Seller seller){
        this.id = coffinSales.getId();
        this.nomeVendedor = seller.getNome();
        this.modeloCaixao = coffin.getModelo();
        this.dataVenda = coffinSales.getDataVenda();

    }

    public static CoffinSalesResponse from(CoffinSales coffinSales, Coffin coffin, Seller seller){ return new CoffinSalesResponse(coffinSales, coffin,  seller);}
}
