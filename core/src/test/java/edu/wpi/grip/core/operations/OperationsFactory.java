package edu.wpi.grip.core.operations;


import edu.wpi.grip.core.operations.network.MapNetworkPublisherFactory;
import edu.wpi.grip.core.operations.network.MockMapNetworkPublisher;
import edu.wpi.grip.core.operations.network.ros.JavaToMessageConverter;
import edu.wpi.grip.core.operations.network.ros.ROSMessagePublisher;
import edu.wpi.grip.core.operations.network.ros.ROSNetworkPublisherFactory;
import edu.wpi.grip.core.sockets.InputSocket;
import edu.wpi.grip.core.sockets.MockInputSocketFactory;
import edu.wpi.grip.core.sockets.MockOutputSocketFactory;
import edu.wpi.grip.core.sockets.OutputSocket;

import com.google.common.eventbus.EventBus;

import java.util.Optional;

public class OperationsFactory {

  public static Operations create(EventBus eventBus) {
    return create(eventBus,
        MockMapNetworkPublisher::new,
        MockMapNetworkPublisher::new,
        MockROSMessagePublisher::new,
        new MockInputSocketFactory(eventBus),
        new MockOutputSocketFactory(eventBus));
  }

  public static Operations create(EventBus eventBus,
                                  MapNetworkPublisherFactory mapFactory,
                                  MapNetworkPublisherFactory httpFactory,
                                  ROSNetworkPublisherFactory rosFactory,
                                  InputSocket.Factory isf,
                                  OutputSocket.Factory osf) {
    return new Operations(eventBus, mapFactory, httpFactory, rosFactory, isf, osf);
  }

  public static CVOperations createCV(EventBus eventBus) {
    return new CVOperations(eventBus, new MockInputSocketFactory(eventBus), new
        MockOutputSocketFactory(eventBus));
  }

  private static class MockROSMessagePublisher<C extends JavaToMessageConverter> extends
      ROSMessagePublisher {
    public MockROSMessagePublisher(C converter) {

    }

    @Override
    public void publish(ROSMessagePublisher.Converter publish) {

    }

    @Override
    protected void publishNameChanged(Optional<String> oldName, String newName) {

    }

    @Override
    public void close() {

    }
  }
}