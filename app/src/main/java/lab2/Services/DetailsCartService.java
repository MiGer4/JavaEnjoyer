package lab2.Services;

import lab2.DetailsCart;
// import lab2.Comparators.ProductComparator;
import lombok.AllArgsConstructor;

// import java.util.List;
// import java.util.Collections;

@AllArgsConstructor
public class DetailsCartService {
    private DetailsCart detailsCart;

    public double getTotalProductCost() {
        return detailsCart.getGoods().stream().mapToDouble(pr -> pr.getPrice()).sum();
    }

}
