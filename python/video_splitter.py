import subprocess

# Input video file path
video_path = "input_video.mp4"

# Define the split time (in seconds)
split_time = 40  # Example: split at 30 seconds; adjust as needed

# First part: from 0 seconds to split_time
output_part1 = "output_part1.mp4"
subprocess.run([
    "ffmpeg", "-i", video_path, "-t", str(split_time), 
    "-c", "copy", output_part1
])

# Second part: from split_time to the end
output_part2 = "output_part2.mp4"
subprocess.run([
    "ffmpeg", "-i", video_path, "-ss", str(split_time), 
    "-c", "copy", output_part2
])