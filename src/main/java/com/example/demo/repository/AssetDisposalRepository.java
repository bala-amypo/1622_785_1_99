package com.example.demo.repository;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * PDF Rule 4.7: Required for audit trail by approver.
 * Used in Test 80 and 84.
 */
public interface AssetDisposalRepository extends JpaRepository<AssetDisposal, Long> {
    List<AssetDisposal> findByApprovedBy(User approvedBy);
}