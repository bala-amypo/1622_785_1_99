package com.example.demo.service;

import com.example.demo.entity.AssetDisposal;
import java.util.List;

public interface AssetDisposalService {

    AssetDisposal saveDisposal(AssetDisposal disposal);

    List<AssetDisposal> getDisposalsByApprover(Long userId);
}
