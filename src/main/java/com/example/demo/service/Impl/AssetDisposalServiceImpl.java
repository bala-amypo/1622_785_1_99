package com.example.demo.service.Impl;
import com.example.demo.entity.AssetDisposalentity;
import com.example.demo.repository.AssetDisposalRepository;
import com.example.demo.service.AssetDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {

    @Autowired
    private AssetDisposalRepository disposalRepository;

    @Override
    public AssetDisposalentity saveDisposal(AssetDisposalentity disposal) {
        return disposalRepository.save(disposal);
    }

    @Override
    public List<AssetDisposalentity> getAllDisposals() {
        return disposalRepository.findAll();
    }
}
