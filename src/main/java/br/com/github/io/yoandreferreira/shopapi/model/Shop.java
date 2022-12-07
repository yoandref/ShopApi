package br.com.github.io.yoandreferreira.shopapi.model;

import br.com.github.io.yoandreferreira.shopapi.dto.ShopDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identifier;
    private String status;
    @Column(name = "date_shop")
    private LocalDate dateShop;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "shop")
    private List<ShopItem> items;

    public static Shop convert(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setIdentifier(shopDTO.getIdentifier());
        shop.setStatus(shopDTO.getStatus());
        shop.setDateShop(shopDTO.getDateShop());
        shop.setItems(shopDTO.getItems().stream().map(ShopItem::convert).collect(Collectors.toList()));
        return shop;
    }

//    create table shop (id bigserial primary key auto_increment, identifier varchar not null, status varchar not null, date_shop date);
//
//    create table shop_item (
//            id bigserial primary key auto_increment,
//            product_identifier varchar(100) not null,
//    amount int not null,
//    price float not null,
//    shop_id bigint REFERENCES shop(id)
//);

}
