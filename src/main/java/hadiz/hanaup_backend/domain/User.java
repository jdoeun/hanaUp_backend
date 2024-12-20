package hadiz.hanaup_backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hadiz.hanaup_backend.domain.after.ForeignCurrencyAccount;
import hadiz.hanaup_backend.domain.before.PastTravelCostPrediction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "users")  // 테이블 이름을 'users'로 변경
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // test때에는 주석 처리. api 만들 때 켜기
    private Long userID;

    private String travelState; // 여행 상태 "before", "during", "after"


    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ForeignCurrencyAccount> foreignCurrencyAccounts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HanaMoneyByCurrency> hanaMoneyByCurrencies = new ArrayList<>();
}
