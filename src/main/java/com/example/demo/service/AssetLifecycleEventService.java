package com.example.demo.service;

import com.example.demo.entity.AssetLifecycleEvent;
import java.util.List;

public interface AssetLifecycleEventService {

    AssetLifecycleEvent saveEvent(AssetLifecycleEvent event);

    List<AssetLifecycleEvent> getEventsByAssetId(Long assetId);
}
