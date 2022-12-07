package br.com.github.io.yoandreferreira.shopapi.controller;

import br.com.github.io.yoandreferreira.shopapi.dto.ShopDTO;
import br.com.github.io.yoandreferreira.shopapi.model.Shop;
import br.com.github.io.yoandreferreira.shopapi.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopRepository shopRepository;

    @GetMapping
    public List<ShopDTO> getShop() {
        return shopRepository.findAll().stream().map(ShopDTO::convert).collect(Collectors.toList());
    }

    @PostMapping
    public ShopDTO saveShop(@RequestBody ShopDTO shopDTO) {
        shopDTO.setIdentifier(UUID.randomUUID().toString());
        shopDTO.setDateShop(LocalDate.now());
        shopDTO.setStatus("PENDING");

        Shop shop = Shop.convert(shopDTO);
        shop.getItems().forEach(shopItem -> shopItem.setShop(shop));
        return ShopDTO.convert(shopRepository.save(shop));
    }

}
