package sample.springboot.multipledatasources.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.springboot.multipledatasources.core.model.Channel;
import sample.springboot.multipledatasources.core.repo.read.ChannelReadRepo;
import sample.springboot.multipledatasources.core.repo.write.ChannelWriteRepo;

import java.util.List;

/**
 * @author Slavko Komarica
 */
@Service
public class ChannelService {

    private Logger logger = LoggerFactory.getLogger(ChannelService.class);

    private final ChannelReadRepo channelReadRepo;
    private final ChannelWriteRepo channelWriteRepo;

    public ChannelService(ChannelReadRepo channelReadRepo, ChannelWriteRepo channelWriteRepo) {
        this.channelReadRepo = channelReadRepo;
        this.channelWriteRepo = channelWriteRepo;
    }

    @Transactional(readOnly = true)
    public List<Channel> getAll() {
        logger.info("Finding all channels...");

        List<Channel> channels = channelReadRepo.findAll();

        logger.info("All channels found, {}", channels);

        return channels;
    }

    @Transactional(readOnly = false)
    public void create(Channel channel) {
        logger.info("Saving channel: {}", channel);

        channel = channelWriteRepo.save(channel);

        logger.info("Channel saved: {}", channel);
    }

}
