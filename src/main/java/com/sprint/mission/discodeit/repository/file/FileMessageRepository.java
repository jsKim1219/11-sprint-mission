package com.sprint.mission.discodeit.repository.file;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.repository.MessageRepository;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FileMessageRepository implements MessageRepository {
    private void saveMessages(List<Message> messages) {
        try (FileOutputStream fos = new FileOutputStream("message.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(messages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Message> loadMessages() {
        File file = new File("message.ser");

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fis = new FileInputStream("message.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (List<Message>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void save(Message message) {
        List<Message> messages = loadMessages();
        messages.removeIf(m -> m.getId().equals(message.getId()));
        messages.add(message);
        saveMessages(messages);
    }

    @Override
    public Message findById(UUID id) {
        return loadMessages().stream()
                .filter(message -> message.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Message> findAll() {
        return loadMessages();
    }

    @Override
    public void delete(UUID id) {
        List<Message> messages = loadMessages();
        messages.removeIf(message -> message.getId().equals(id));
        saveMessages(messages);
    }
}
