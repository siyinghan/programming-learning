import os
import subprocess

# Define input and output folder paths
input_folder = "video"
output_file = "video/output.mp4"

# List all video files in the folder with common video formats
video_files = [os.path.join(input_folder, f) for f in os.listdir(input_folder) if f.endswith("mp4")]
video_files.sort()

# Ensure there are video files to process
if not video_files:
    print("No video files found in the folder.")
    exit()

# Create a text file that lists all video files for FFmpeg
with open("video_list.txt", "w") as file_list:
    for video in video_files:
        # FFmpeg requires paths to be specified in the format: file 'filename'
        file_list.write(f"file '{os.path.abspath(video)}'\n")

# FFmpeg command to concatenate without re-encoding (copying the streams)
ffmpeg_command = [
    'ffmpeg', 
    '-f', 'concat',            # Tell FFmpeg to use concat demuxer
    '-safe', '0',              # Required for full paths in the list file
    '-i', 'video_list.txt',    # Input is the file list
    '-c', 'copy',              # Copy the streams (no re-encoding)
    output_file                # Output file
]

# Run the FFmpeg command
subprocess.run(ffmpeg_command)

# Clean up the temporary text file
os.remove("video_list.txt")

print(f"All videos have been merged and saved as {output_file}")