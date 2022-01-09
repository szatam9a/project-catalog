package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {
    private final List<String> composer;
    private final int length;
    private List<String> performers;
    private final String title;

    public AudioFeatures(String title, int length, List<String> composer) {
        Validators.validateAudioFeatures(title,length,composer);
        this.composer = composer;
        this.length = length;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> composer, List<String> performers) {
        Validators.validateAudioFeatures(title,length,composer,performers);
        this.composer = composer;
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        List<String> result = new ArrayList<>();
        if (!Validators.isEmpty(performers)) {
            result.addAll(performers);
        }
        if (!Validators.isEmpty(composer)) {
            result.addAll(composer);
        }
        return result;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
