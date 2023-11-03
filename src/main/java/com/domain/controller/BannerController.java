package com.domain.controller;

import com.domain.model.BannerResponse;
import com.domain.model.ApiResponse;
import com.domain.service.BannerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/services")
public class BannerController {
    private final BannerService bannerService;


    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping
    public ApiResponse getServices() {
        List<com.domain.model.entities.Banner> banners = bannerService.getAllBanner();
        List<BannerResponse> bannerResponses = banners.stream()
                .map(banner -> new BannerResponse(banner.getBannerName(), banner.getBannerImage(), banner.getDescription()))
                .collect(Collectors.toList());
        return new ApiResponse(0, "Sukses", bannerResponses);
    }
}
