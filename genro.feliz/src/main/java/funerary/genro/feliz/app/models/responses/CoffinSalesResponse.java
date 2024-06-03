package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.Coffin;
import funerary.genro.feliz.domain.CoffinSales;
import funerary.genro.feliz.domain.Seller;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CoffinSalesResponse {

    private Long id;

    private String nomeVendedor;

    private String modeloCaixao;

    private LocalDate dataVenda;

    public CoffinSalesResponse(CoffinSales coffinSales){
        this.id = coffinSales.getId();
        this.nomeVendedor = coffinSales.getSeller().getNome();
        this.modeloCaixao = coffinSales.getCoffin().getModelo();
        this.dataVenda = coffinSales.getDataVenda();

    }

    public static CoffinSalesResponse from(CoffinSales coffinSales){ return new CoffinSalesResponse(coffinSales);}
}
