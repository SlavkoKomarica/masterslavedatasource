package sample.springboot.multipledatasources.core.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.springboot.multipledatasources.core.model.Channel;
import sample.springboot.multipledatasources.core.service.ChannelService;

import java.util.List;

/**
 * @author Slavko Komarica
 */
@RestController
@RequestMapping(value = "/channels")
public class ChannelController {

    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping
    public ResponseEntity<List<Channel>> getAll() {
        List<Channel> channels = channelService.getAll();

        return ResponseEntity.ok(channels);
    }

    @PostMapping
    public ResponseEntity<Void> create() {
        Channel channelMock = new Channel("Pink televizija", "Pink tv");
        channelService.create(channelMock);

        return ResponseEntity.noContent().build();
    }
}
