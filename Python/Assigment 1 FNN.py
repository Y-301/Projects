import tensorflow as tf 
from tensorflow.keras.datasets import mnist 
from tensorflow.keras.models import Sequential 
from tensorflow.keras.layers import Dense 
import matplotlib.pyplot as plt 

batch_size = 128 
num_classes = 10 
epochs = 10

(x_train, y_train), (x_test, y_test) = mnist.load_data()

x_train = x_train.reshape(60000, 784).astype('float32') / 255 
x_test = x_test.reshape(10000, 784).astype('float32') / 255 

y_train = tf.keras.utils.to_categorical(y_train, num_classes)
y_test = tf.keras.utils.to_categorical(y_test, num_classes)

model = Sequential()

model.add(Dense(512, activation='relu', input_shape=(784,))) 

model.add(Dense(512, activation='relu')) 

model.add(Dense(10, activation='softmax')) 
model.summary() 

model.compile(loss='categorical_crossentropy', 

optimizer=tf.keras.optimizers.Adam(learning_rate=0.01), 
metrics=['accuracy']) 

history = model.fit(x_train, y_train,
 batch_size=batch_size,
 epochs=epochs,
 verbose=1, 
 validation_data=(x_test, y_test)) 

plt.plot(history.history['loss'], label='Training Loss')
plt.plot(history.history['val_loss'], label='Validation Loss')
plt.title('Training Loss vs Validation Loss')
plt.xlabel('Epoch')
plt.ylabel('Loss')
plt.legend()
plt.show()

score = model.evaluate(x_test, y_test, verbose=0)
print('Test loss:', score[0]) 
print('Test accuracy:', score[1]) 
