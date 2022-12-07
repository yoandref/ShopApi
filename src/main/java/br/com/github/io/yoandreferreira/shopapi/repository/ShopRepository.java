package br.com.github.io.yoandreferreira.shopapi.repository;

import br.com.github.io.yoandreferreira.shopapi.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
