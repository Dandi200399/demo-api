package com.domain.service;

import com.domain.model.entities.Banner;
import com.domain.model.repository.BannerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    private final BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    public List<Banner> getAllBanner() {
        return (List<Banner>) bannerRepository.findAll();
    }
}
