package hadiz.hanaup_backend.domain.after;

import hadiz.hanaup_backend.domain.HanaMoneyByCurrency;
import hadiz.hanaup_backend.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "foreign_currency_account")
@Getter @Setter
public class ForeignCurrencyAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountID;

    private int period;

    private String currencyID;
    private String country;
    private Double firstBalance;
    private BigDecimal interest;
    private BigDecimal lastBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}

