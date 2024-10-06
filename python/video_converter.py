import os
from moviepy.editor import VideoFileClip

# Define input and output folder paths
input_folder = "video"
output_folder = "video_new"

# Ensure output and processed folders exist
os.makedirs(output_folder, exist_ok=True)
# os.makedirs(processed_folder, exist_ok=True)

# Set the target resolution for 4K (16:9 aspect ratio)
target_width = 3840
target_height = 2160

# List all video files in the folder with common video formats
video_files = [os.path.join(input_folder, f) for f in os.listdir(input_folder) if f.endswith("mp4")]

# Sort video files by name in alphabetical order
video_files.sort()

# Process each video one by one
for idx, video_file in enumerate(video_files):
    base_name, ext = os.path.splitext(os.path.basename(video_file))  # Get file name and extension
    
    print(f"Processing video {idx + 1}/{len(video_files)}: {base_name}{ext}")

    try:
        # Open the video file
        clip = VideoFileClip(video_file)

        # Get the aspect ratio of the current video
        video_aspect_ratio = clip.w / clip.h

        # Calculate the aspect ratio for 16:9
        target_aspect_ratio = target_width / target_height

        # Resize directly to 4K resolution if the aspect ratio matches 16:9
        if video_aspect_ratio == target_aspect_ratio:
            clip_resized = clip.resize(newsize=(target_width, target_height))
        
        # If the aspect ratio differs, fit it into 4K with black bars
        else:
            clip_resized = clip.resize(height=target_height).on_color(size=(target_width, target_height), color=(0, 0, 0), pos='center')

        # Define output file path
        output_file = os.path.join(output_folder, f"{base_name}_4k{ext}")

        # Export the processed video in 4K
        clip_resized.write_videofile(output_file, codec="libx264", fps=24)

        # Close clips to free memory
        clip.close()
        clip_resized.close()

        print(f"Finished processing {base_name}{ext}. Saved as {output_file}.")

        # Delete the original video after successful processing
        os.remove(video_file)
        print(f"Original video {base_name}{ext} has been deleted.")

    except Exception as e:
        # Handle exceptions (e.g., video processing failure)
        print(f"Error processing {base_name}{ext}: {e}")
        print(f"Skipping {base_name}{ext} and continuing...")

    # Optional: Explicit garbage collection to free memory
    import gc
    gc.collect()

print("All videos have been processed. Original files moved or skipped on failure.")