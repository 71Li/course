package com.coursesystem.service;

import com.coursesystem.model.vo.response.ResultVO;
import com.coursesystem.manager.SdnuNewsManager;
import com.coursesystem.model.vo.response.table.SdnuNewsItemVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SdnuNewsService extends BaseService {
    private final SdnuNewsManager manager;

    public SdnuNewsService(SdnuNewsManager manager) {
        this.manager = manager;
    }

    public ResultVO getAllNews() {
        List<SdnuNewsItemVO> voList = SdnuNewsItemVO.fromSdnuNewsBOList(manager.getAllNews());
        voList.sort((a, b) -> b.getDate().compareTo(a.getDate()));

        return result(voList);
    }
}
