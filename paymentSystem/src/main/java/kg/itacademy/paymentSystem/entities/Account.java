package kg.itacademy.paymentSystem.entities;

import kg.itacademy.paymentSystem.enums.Currency;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@FieldDefaults(level =AccessLevel.PRIVATE)
@Table(name = "p_accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "account_number")
    String accountNumber;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    Client client;

    @Column(name = "balance")
    BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    Currency currency;
}
