package com.example.demo.service.impl;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.entity.User;
import com.example.demo.repository.AssetDisposalRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AssetDisposalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {

    private final AssetDisposalRepository disposalRepository;
    private final UserRepository userRepository;

    public AssetDisposalServiceImpl(AssetDisposalRepository disposalRepository,
                                    UserRepository userRepository) {
        this.disposalRepository = disposalRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AssetDisposal saveDisposal(AssetDisposal disposal) {
        return disposalRepository.save(disposal);
    }

    @Override
    public List<AssetDisposal> getDisposalsByApprover(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return disposalRepository.findByApprovedBy(user);
    }
}
