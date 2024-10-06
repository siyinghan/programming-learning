import subprocess

# Input video file path
video_path = "input_video.mp4"

# Output video file path
output_path = "rotated_video.mp4"

# Rotate the video 90 degrees clockwise using ffmpeg with encoding
# The transpose=1 filter rotates the video 90 degrees clockwise
subprocess.run([
    "ffmpeg", "-i", video_path, "-vf", "transpose=2", 
    "-c:v", "libx264", "-c:a", "aac", output_path
])