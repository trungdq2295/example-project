package com.example.videostreaming.service.impl;


import com.example.videostreaming.exception.VideoAlreadyExistsException;
import com.example.videostreaming.exception.VideoNotFoundException;
import com.example.videostreaming.model.Video;
import com.example.videostreaming.repository.VideoRepository;
import com.example.videostreaming.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class VideoServiceImpl  implements VideoService {

    private VideoRepository videoRepository;
    @Override
    public Video getVideoByName(String name) {

        Map<String, Function<String,Void>> map = new HashMap<>();

        if(!videoRepository.existsByName(name)){
            throw new VideoNotFoundException("Fail");
        }
        return videoRepository.findByName(name);
    }

    @Override
    public void saveVideo(MultipartFile file, String name) throws IOException {
        if(videoRepository.existsByName(name)){
            throw new VideoAlreadyExistsException("Fail");
        }
        Video newVid = new Video("test", file.getBytes());
        videoRepository.save(newVid);
    }

    @Override
    public List<String> getAllVideoNames() {
        return videoRepository.getAllEntryNames();
    }
}
