package com.domain.model.repository;

import com.domain.model.entities.Banner;
import org.springframework.data.repository.CrudRepository;

public interface BannerRepository extends CrudRepository<Banner, Long> {
    // Tambahkan metode khusus jika diperlukan
}

