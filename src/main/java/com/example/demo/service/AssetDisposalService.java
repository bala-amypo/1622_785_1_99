package com.example.demo.service;
import com.example.demo.entity.AssetDisposalentity;
import java.util.List;

public interface AssetDisposalService {

    AssetDisposalentity saveDisposal(AssetDisposalentity disposal);
    List<AssetDisposalentity> getAllDisposals();
}
