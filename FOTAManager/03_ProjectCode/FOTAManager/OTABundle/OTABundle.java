package com.sloki.FOTAManager.OTABundle;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;


public class OTABundle {
    private List<bundleDirectories> firmwareImageFiles;
    private List<bundleDirectories> udsFlowConfigFiles;
    private Uri configurationFile;
    private String licenseAgreementFile;
    private Uri manifestFile;
    private Uri signatureFile;

    public OTABundle() {
        firmwareImageFiles = new ArrayList<>();
        udsFlowConfigFiles = new ArrayList<>();
    }

    public List<bundleDirectories> getFirmwareImageFiles() {
        return firmwareImageFiles;
    }

    public void addFirmwareImageFile(bundleDirectories firmwareImageFile) {
        firmwareImageFiles.add(firmwareImageFile);
    }

    public List<bundleDirectories> getUdsFlowConfigFiles() {
        return udsFlowConfigFiles;
    }

    public void addUdsFlowConfigFile(bundleDirectories udsFlowConfigFile) {
        udsFlowConfigFiles.add(udsFlowConfigFile);
    }

    public Uri getConfigurationFile() {
        return configurationFile;
    }

    public void setConfigurationFile(Uri configurationFile) {
        this.configurationFile = configurationFile;
    }

    public String getLicenseAgreementFile() {
        return licenseAgreementFile;
    }

    public void setLicenseAgreementFile(String licenseAgreementFile) {
        this.licenseAgreementFile = licenseAgreementFile;
    }

    public Uri getManifestFile() {
        return manifestFile;
    }

    public void setManifestFile(Uri manifestFile) {
        this.manifestFile = manifestFile;
    }

    public Uri getSignatureFile() {
        return signatureFile;
    }

    public void setSignatureFile(Uri signatureFile) {
        this.signatureFile = signatureFile;
    }

    @Override
    public String toString() {
        return "OTABundle{" +
                "firmwareImageFiles=" + firmwareImageFiles +
                ", udsFlowConfigFiles=" + udsFlowConfigFiles +
                ", configurationFile='" + configurationFile + '\'' +
                ", licenseAgreementFile='" + licenseAgreementFile + '\'' +
                ", manifestFile='" + manifestFile + '\'' +
                ", signatureFile='" + signatureFile + '\'' +
                '}';
    }


}
