package com.entertainment;

import java.util.Objects;

/*
NOTE: To be consistent with equals, you must use the same sort key(s) as
you're using in hte equals method - Here is (brand, volume)
 */
public class Television implements Comparable<Television> {
    private String brand;
    private int volume;
    private Tuner tuner = new Tuner();

    public Television() {
    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Television that = (Television) obj;
        return getVolume() == that.getVolume() && Objects.equals(this.getBrand(), that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }


    /*    @Override
    public int hashCode() {
        // return getBrand().length() + getVolume();

        // this is a scientifically correct hash function
        return Objects.hash(getBrand(), getVolume());
    }*/

/*    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        // check that "obj" is really referring to a Television object
//        if (obj instanceof Television) {    // as IS-A check
        if (this.getClass() == obj.getClass()) {    // are we the exact same type?
            // downcast "obj" to more specific reference type
            Television other = (Television)obj;
            // do the checks: business equality is defined as brand, volume
            result = Objects.equals(this.getBrand(), other.getBrand()) &&   // null-safe check
                    this.getVolume() == other.getVolume();                  // primitives cant be null
        }

        return result;
    }*/

    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if(result == 0){
            result = Integer.compare(this.getVolume(), other.getVolume());
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format(getClass().getSimpleName() + "brand= %s, volume= %s, currentChannel= %s",
                getBrand(), getVolume(), getCurrentChannel());
    }
}
