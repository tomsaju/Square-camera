# Square Camera 
A sample camera application that has an instagram like square preview and uses Camera 2 API.

This uses camera fragment from [google samples](https://github.com/googlesamples/android-Camera2Basic) for camera2 API.
For making the camera square, some part of textureview is covered with a framelayout. The part of camera preview will have the same width and height which will be equal to device width. The final image is cropped to get a square image after capturing. 

This sample allows switching between camera's so that you can use both cameras.
