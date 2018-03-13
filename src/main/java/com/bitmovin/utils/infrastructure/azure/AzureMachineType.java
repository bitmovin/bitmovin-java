package com.bitmovin.utils.infrastructure.azure;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arudich on 13.09.17.
 **/
public enum AzureMachineType
{
    BASIC_A0         ("Basic_A0"),
    BASIC_A1         ("Basic_A1"),
    BASIC_A2         ("Basic_A2"),
    BASIC_A3         ("Basic_A3"),
    BASIC_A4         ("Basic_A4"),
    STANDARD_A0      ("Standard_A0"),
    STANDARD_A1      ("Standard_A1"),
    STANDARD_A2      ("Standard_A2"),
    STANDARD_A3      ("Standard_A3"),
    STANDARD_A4      ("Standard_A4"),
    STANDARD_A5      ("Standard_A5"),
    STANDARD_A6      ("Standard_A6"),
    STANDARD_A7      ("Standard_A7"),
    STANDARD_A8      ("Standard_A8"),
    STANDARD_A9      ("Standard_A9"),
    STANDARD_A10     ("Standard_A10"),
    STANDARD_A11     ("Standard_A11"),
    STANDARD_A1_V2   ("Standard_A1_v2"),
    STANDARD_A2_V2   ("Standard_A2_v2"),
    STANDARD_A4_V2   ("Standard_A4_v2"),
    STANDARD_A8_V2   ("Standard_A8_v2"),
    STANDARD_A2M_V2  ("Standard_A2m_v2"),
    STANDARD_A4M_V2  ("Standard_A4m_v2"),
    STANDARD_A8M_V2  ("Standard_A8m_v2"),
    STANDARD_D1      ("Standard_D1"),
    STANDARD_D2      ("Standard_D2"),
    STANDARD_D3      ("Standard_D3"),
    STANDARD_D4      ("Standard_D4"),
    STANDARD_D11     ("Standard_D11"),
    STANDARD_D12     ("Standard_D12"),
    STANDARD_D13     ("Standard_D13"),
    STANDARD_D14     ("Standard_D14"),
    STANDARD_D1_V2   ("Standard_D1_v2"),
    STANDARD_D2_V2   ("Standard_D2_v2"),
    STANDARD_D3_V2   ("Standard_D3_v2"),
    STANDARD_D4_V2   ("Standard_D4_v2"),
    STANDARD_D5_V2   ("Standard_D5_v2"),
    STANDARD_D11_V2  ("Standard_D11_v2"),
    STANDARD_D12_V2  ("Standard_D12_v2"),
    STANDARD_D13_V2  ("Standard_D13_v2"),
    STANDARD_D14_V2  ("Standard_D14_v2"),
    STANDARD_D15_V2  ("Standard_D15_v2"),
    STANDARD_DS1     ("Standard_DS1"),
    STANDARD_DS2     ("Standard_DS2"),
    STANDARD_DS3     ("Standard_DS3"),
    STANDARD_DS4     ("Standard_DS4"),
    STANDARD_DS11    ("Standard_DS11"),
    STANDARD_DS12    ("Standard_DS12"),
    STANDARD_DS13    ("Standard_DS13"),
    STANDARD_DS14    ("Standard_DS14"),
    STANDARD_DS1_V2  ("Standard_DS1_v2"),
    STANDARD_DS2_V2  ("Standard_DS2_v2"),
    STANDARD_DS3_V2  ("Standard_DS3_v2"),
    STANDARD_DS4_V2  ("Standard_DS4_v2"),
    STANDARD_DS5_V2  ("Standard_DS5_v2"),
    STANDARD_DS11_V2 ("Standard_DS11_v2"),
    STANDARD_DS12_V2 ("Standard_DS12_v2"),
    STANDARD_DS13_V2 ("Standard_DS13_v2"),
    STANDARD_DS14_V2 ("Standard_DS14_v2"),
    STANDARD_DS15_V2 ("Standard_DS15_v2"),
    STANDARD_F1      ("Standard_F1"),
    STANDARD_F2      ("Standard_F2"),
    STANDARD_F4      ("Standard_F4"),
    STANDARD_F8      ("Standard_F8"),
    STANDARD_F16     ("Standard_F16"),
    STANDARD_F1S     ("Standard_F1s"),
    STANDARD_F2S     ("Standard_F2s"),
    STANDARD_F4S     ("Standard_F4s"),
    STANDARD_F8S     ("Standard_F8s"),
    STANDARD_F16S    ("Standard_F16s"),
    STANDARD_G1      ("Standard_G1"),
    STANDARD_G2      ("Standard_G2"),
    STANDARD_G3      ("Standard_G3"),
    STANDARD_G4      ("Standard_G4"),
    STANDARD_G5      ("Standard_G5"),
    STANDARD_GS1     ("Standard_GS1"),
    STANDARD_GS2     ("Standard_GS2"),
    STANDARD_GS3     ("Standard_GS3"),
    STANDARD_GS4     ("Standard_GS4"),
    STANDARD_GS5     ("Standard_GS5"),
    STANDARD_H8      ("Standard_H8"),
    STANDARD_H16     ("Standard_H16"),
    STANDARD_H8M     ("Standard_H8m"),
    STANDARD_H16M    ("Standard_H16m"),
    STANDARD_H16R    ("Standard_H16r"),
    STANDARD_H16MR   ("Standard_H16mr"),
    STANDARD_L4S     ("Standard_L4s"),
    STANDARD_L8S     ("Standard_L8s"),
    STANDARD_L16S    ("Standard_L16s"),
    STANDARD_L32S    ("Standard_L32s"),
    STANDARD_NC6     ("Standard_NC6"),
    STANDARD_NC12    ("Standard_NC12"),
    STANDARD_NC24    ("Standard_NC24"),
    STANDARD_NC24R   ("Standard_NC24r"),
    STANDARD_NV6     ("Standard_NV6"),
    STANDARD_NV12    ("Standard_NV12"),
    STANDARD_NV24    ("Standard_NV24"),
    STANDARD_D8S_V3  ("Standard_D8s_v3");

    private String name;
    private static Map<String, AzureMachineType> map = new HashMap<>();

    static
    {
        map.put("Basic_A0",         BASIC_A0);
        map.put("Basic_A1",         BASIC_A1);
        map.put("Basic_A2",         BASIC_A2);
        map.put("Basic_A3",         BASIC_A3);
        map.put("Basic_A4",         BASIC_A4);
        map.put("Standard_A0",      STANDARD_A0);
        map.put("Standard_A1",      STANDARD_A1);
        map.put("Standard_A2",      STANDARD_A2);
        map.put("Standard_A3",      STANDARD_A3);
        map.put("Standard_A4",      STANDARD_A4);
        map.put("Standard_A5",      STANDARD_A5);
        map.put("Standard_A6",      STANDARD_A6);
        map.put("Standard_A7",      STANDARD_A7);
        map.put("Standard_A8",      STANDARD_A8);
        map.put("Standard_A9",      STANDARD_A9);
        map.put("Standard_A10",     STANDARD_A10);
        map.put("Standard_A11",     STANDARD_A11);
        map.put("Standard_A1_v2",   STANDARD_A1_V2);
        map.put("Standard_A2_v2",   STANDARD_A2_V2);
        map.put("Standard_A4_v2",   STANDARD_A4_V2);
        map.put("Standard_A8_v2",   STANDARD_A8_V2);
        map.put("Standard_A2m_v2",  STANDARD_A2M_V2);
        map.put("Standard_A4m_v2",  STANDARD_A4M_V2);
        map.put("Standard_A8m_v2",  STANDARD_A8M_V2);
        map.put("Standard_D1",      STANDARD_D1);
        map.put("Standard_D2",      STANDARD_D2);
        map.put("Standard_D3",      STANDARD_D3);
        map.put("Standard_D4",      STANDARD_D4);
        map.put("Standard_D11",     STANDARD_D11);
        map.put("Standard_D12",     STANDARD_D12);
        map.put("Standard_D13",     STANDARD_D13);
        map.put("Standard_D14",     STANDARD_D14);
        map.put("Standard_D1_v2",   STANDARD_D1_V2);
        map.put("Standard_D2_v2",   STANDARD_D2_V2);
        map.put("Standard_D3_v2",   STANDARD_D3_V2);
        map.put("Standard_D4_v2",   STANDARD_D4_V2);
        map.put("Standard_D5_v2",   STANDARD_D5_V2);
        map.put("Standard_D11_v2",  STANDARD_D11_V2);
        map.put("Standard_D12_v2",  STANDARD_D12_V2);
        map.put("Standard_D13_v2",  STANDARD_D13_V2);
        map.put("Standard_D14_v2",  STANDARD_D14_V2);
        map.put("Standard_D15_v2",  STANDARD_D15_V2);
        map.put("Standard_DS1",     STANDARD_DS1);
        map.put("Standard_DS2",     STANDARD_DS2);
        map.put("Standard_DS3",     STANDARD_DS3);
        map.put("Standard_DS4",     STANDARD_DS4);
        map.put("Standard_DS11",    STANDARD_DS11);
        map.put("Standard_DS12",    STANDARD_DS12);
        map.put("Standard_DS13",    STANDARD_DS13);
        map.put("Standard_DS14",    STANDARD_DS14);
        map.put("Standard_DS1_v2",  STANDARD_DS1_V2);
        map.put("Standard_DS2_v2",  STANDARD_DS2_V2);
        map.put("Standard_DS3_v2",  STANDARD_DS3_V2);
        map.put("Standard_DS4_v2",  STANDARD_DS4_V2);
        map.put("Standard_DS5_v2",  STANDARD_DS5_V2);
        map.put("Standard_DS11_v2", STANDARD_DS11_V2);
        map.put("Standard_DS12_v2", STANDARD_DS12_V2);
        map.put("Standard_DS13_v2", STANDARD_DS13_V2);
        map.put("Standard_DS14_v2", STANDARD_DS14_V2);
        map.put("Standard_DS15_v2", STANDARD_DS15_V2);
        map.put("Standard_F1",      STANDARD_F1);
        map.put("Standard_F2",      STANDARD_F2);
        map.put("Standard_F4",      STANDARD_F4);
        map.put("Standard_F8",      STANDARD_F8);
        map.put("Standard_F16",     STANDARD_F16);
        map.put("Standard_F1s",     STANDARD_F1S);
        map.put("Standard_F2s",     STANDARD_F2S);
        map.put("Standard_F4s",     STANDARD_F4S);
        map.put("Standard_F8s",     STANDARD_F8S);
        map.put("Standard_F16s",    STANDARD_F16S);
        map.put("Standard_G1",      STANDARD_G1);
        map.put("Standard_G2",      STANDARD_G2);
        map.put("Standard_G3",      STANDARD_G3);
        map.put("Standard_G4",      STANDARD_G4);
        map.put("Standard_G5",      STANDARD_G5);
        map.put("Standard_GS1",     STANDARD_GS1);
        map.put("Standard_GS2",     STANDARD_GS2);
        map.put("Standard_GS3",     STANDARD_GS3);
        map.put("Standard_GS4",     STANDARD_GS4);
        map.put("Standard_GS5",     STANDARD_GS5);
        map.put("Standard_H8",      STANDARD_H8);
        map.put("Standard_H16",     STANDARD_H16);
        map.put("Standard_H8m",     STANDARD_H8M);
        map.put("Standard_H16m",    STANDARD_H16M);
        map.put("Standard_H16r",    STANDARD_H16R);
        map.put("Standard_H16mr",   STANDARD_H16MR);
        map.put("Standard_L4s",     STANDARD_L4S);
        map.put("Standard_L8s",     STANDARD_L8S);
        map.put("Standard_L16s",    STANDARD_L16S);
        map.put("Standard_L32s",    STANDARD_L32S);
        map.put("Standard_NC6",     STANDARD_NC6);
        map.put("Standard_NC12",    STANDARD_NC12);
        map.put("Standard_NC24",    STANDARD_NC24);
        map.put("Standard_NC24r",   STANDARD_NC24R);
        map.put("Standard_NV6",     STANDARD_NV6);
        map.put("Standard_NV12",    STANDARD_NV12);
        map.put("Standard_NV24",    STANDARD_NV24);
        map.put("Standard_D8s_v3",  STANDARD_D8S_V3);
    }

    AzureMachineType(String s)
    {
        this.name = s;
    }

    @JsonCreator
    public static AzureMachineType forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }
}
