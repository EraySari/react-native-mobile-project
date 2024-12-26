package com.analysis.project.bootstrap;

import com.analysis.project.enums.CalculateType;
import com.analysis.project.enums.RoleType;
import com.analysis.project.model.User;
import com.analysis.project.model.ValueRanges;
import com.analysis.project.repository.UserRepository;
import com.analysis.project.repository.ValueRangesRepository;
import com.analysis.project.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Profile("bootstrap")
@RequiredArgsConstructor
@Transactional
@Slf4j
public class Bootstrap implements CommandLineRunner {

    private final ValueRangesRepository valueRangesRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count()<1){
            User admin = new User("admin","password","admin","admin@admin", RoleType.ADMIN);
            User user = new User("user","password","user","user@user", RoleType.USER);

            userService.saveUser(admin);
            userService.saveUser(user);
        }

        if (valueRangesRepository.count() < 1) {

            List<ValueRanges> valueRangesList = List.of(

                    //TODO: ap


                    new ValueRanges(0, 4, "ap", CalculateType.CI95, "IgG", 100.0, 134.0),
                    new ValueRanges(5, 8, "ap", CalculateType.CI95, "IgG", 164.0, 588.0),
                    new ValueRanges(9, 14, "ap", CalculateType.CI95, "IgG", 246.0, 904.0),
                    new ValueRanges(15, 23, "ap", CalculateType.CI95, "IgG", 313.0, 1170.0),
                    new ValueRanges(24, 47, "ap", CalculateType.CI95, "IgG", 295.0, 1156.0),
                    new ValueRanges(48, 83, "ap", CalculateType.CI95, "IgG", 386.0, 1470.0),
                    new ValueRanges(84, 119, "ap", CalculateType.CI95, "IgG", 462.0, 1682.0),
                    new ValueRanges(120, 155, "ap", CalculateType.CI95, "IgG", 503.0, 1580.0),
                    new ValueRanges(156, 191, "ap", CalculateType.CI95, "IgG", 509.0, 1580.0),
                    new ValueRanges(192, 215, "ap", CalculateType.CI95, "IgG", 487.0, 1327.0),
                    new ValueRanges(216, Integer.MAX_VALUE, "ap", CalculateType.CI95, "IgG", 767.0, 1590.0),

                    new ValueRanges(0, 4, "ap", CalculateType.CI95, "IgG1", 56.0, 215.0),
                    new ValueRanges(5, 8, "ap", CalculateType.CI95, "IgG1", 102.0, 369.0),
                    new ValueRanges(9, 14, "ap", CalculateType.CI95, "IgG1", 160.0, 562.0),
                    new ValueRanges(15, 23, "ap", CalculateType.CI95, "IgG1", 209.0, 724.0),
                    new ValueRanges(24, 47, "ap", CalculateType.CI95, "IgG1", 158.0, 721.0),
                    new ValueRanges(48, 83, "ap", CalculateType.CI95, "IgG1", 209.0, 902.0),
                    new ValueRanges(84, 119, "ap", CalculateType.CI95, "IgG1", 253.0, 1019.0),
                    new ValueRanges(120, 155, "ap", CalculateType.CI95, "IgG1", 280.0, 1030.0),
                    new ValueRanges(156, 191, "ap", CalculateType.CI95, "IgG1", 289.0, 934.0),
                    new ValueRanges(192, 215, "ap", CalculateType.CI95, "IgG1", 283.0, 772.0),
                    new ValueRanges(216, Integer.MAX_VALUE, "ap", CalculateType.CI95, "IgG1", 341.0, 894.0),

                    new ValueRanges(0, 4, "ap", CalculateType.CI95, "IgG2", 0.0, 82.0),
                    new ValueRanges(5, 8, "ap", CalculateType.CI95, "IgG2", 0.0, 89.0),
                    new ValueRanges(9, 14, "ap", CalculateType.CI95, "IgG2", 24.0, 98.0),
                    new ValueRanges(15, 23, "ap", CalculateType.CI95, "IgG2", 35.0, 105.0),
                    new ValueRanges(24, 47, "ap", CalculateType.CI95, "IgG2", 39.0, 176.0),
                    new ValueRanges(48, 83, "ap", CalculateType.CI95, "IgG2", 44.0, 316.0),
                    new ValueRanges(84, 119, "ap", CalculateType.CI95, "IgG2", 54.0, 435.0),
                    new ValueRanges(120, 155, "ap", CalculateType.CI95, "IgG2", 66.0, 502.0),
                    new ValueRanges(156, 191, "ap", CalculateType.CI95, "IgG2", 82.0, 516.0),
                    new ValueRanges(192, 215, "ap", CalculateType.CI95, "IgG2", 98.0, 486.0),
                    new ValueRanges(216, Integer.MAX_VALUE, "ap", CalculateType.CI95, "IgG2", 171.0, 632.0),

                    new ValueRanges(0, 4, "ap", CalculateType.CI95, "IgG3", 7.0, 823.0),
                    new ValueRanges(5, 8, "ap", CalculateType.CI95, "IgG3", 11.9, 74.0),
                    new ValueRanges(9, 14, "ap", CalculateType.CI95, "IgG3", 17.3, 63.7),
                    new ValueRanges(15, 23, "ap", CalculateType.CI95, "IgG3", 21.9, 55.0),
                    new ValueRanges(24, 47, "ap", CalculateType.CI95, "IgG3", 17.0, 84.7),
                    new ValueRanges(48, 83, "ap", CalculateType.CI95, "IgG3", 10.8, 94.9),
                    new ValueRanges(84, 119, "ap", CalculateType.CI95, "IgG3", 8.5, 106.0),
                    new ValueRanges(120, 155, "ap", CalculateType.CI95, "IgG3", 11.5, 53.0),
                    new ValueRanges(156, 191, "ap", CalculateType.CI95, "IgG3", 20.0, 103.2),
                    new ValueRanges(192, 215, "ap", CalculateType.CI95, "IgG3", 31.3, 97.6),
                    new ValueRanges(216, Integer.MAX_VALUE, "ap", CalculateType.CI95, "IgG3", 18.4, 106.0),

                    new ValueRanges(0, 4, "ap", CalculateType.CI95, "IgG4", 0.0, 19.8),
                    new ValueRanges(5, 8, "ap", CalculateType.CI95, "IgG4", 0.0, 20.8),
                    new ValueRanges(9, 14, "ap", CalculateType.CI95, "IgG4", 2.5, 22.5),
                    new ValueRanges(15, 23, "ap", CalculateType.CI95, "IgG4", 6.0, 25.0),
                    new ValueRanges(24, 47, "ap", CalculateType.CI95, "IgG4", 6.9, 28.0),
                    new ValueRanges(48, 83, "ap", CalculateType.CI95, "IgG4", 8.8, 34.0),
                    new ValueRanges(84, 119, "ap", CalculateType.CI95, "IgG4", 12.0, 45.0),
                    new ValueRanges(120, 155, "ap", CalculateType.CI95, "IgG4", 16.0, 50.0),
                    new ValueRanges(156, 191, "ap", CalculateType.CI95, "IgG4", 22.0, 48.0),
                    new ValueRanges(192, 215, "ap", CalculateType.CI95, "IgG4", 27.0, 55.0),
                    new ValueRanges(216, Integer.MAX_VALUE, "ap", CalculateType.CI95, "IgG4", 36.0, 60.0),

                    new ValueRanges(0, 4, "ap", CalculateType.CI95, "IgM", 26.0, 122.0),
                    new ValueRanges(5, 8, "ap", CalculateType.CI95, "IgM", 32.0, 132.0),
                    new ValueRanges(9, 14, "ap", CalculateType.CI95, "IgM", 40.0, 143.0),
                    new ValueRanges(15, 23, "ap", CalculateType.CI95, "IgM", 46.0, 152.0),
                    new ValueRanges(24, 47, "ap", CalculateType.CI95, "IgM", 37.0, 184.0),
                    new ValueRanges(48, 83, "ap", CalculateType.CI95, "IgM", 37.0, 224.0),
                    new ValueRanges(84, 119, "ap", CalculateType.CI95, "IgM", 38.0, 251.0),
                    new ValueRanges(120, 155, "ap", CalculateType.CI95, "IgM", 41.0, 255.0),
                    new ValueRanges(156, 191, "ap", CalculateType.CI95, "IgM", 45.0, 244.0),
                    new ValueRanges(192, 215, "ap", CalculateType.CI95, "IgM", 49.0, 201.0),
                    new ValueRanges(216, Integer.MAX_VALUE, "ap", CalculateType.CI95, "IgM", 37.0, 286.0),

                    new ValueRanges(0, 4, "ap", CalculateType.CI95, "IgA", 7.0, 37.0),
                    new ValueRanges(5, 8, "ap", CalculateType.CI95, "IgA", 16.0, 50.0),
                    new ValueRanges(9, 14, "ap", CalculateType.CI95, "IgA", 27.0, 66.0),
                    new ValueRanges(15, 23, "ap", CalculateType.CI95, "IgA", 36.0, 79.0),
                    new ValueRanges(24, 47, "ap", CalculateType.CI95, "IgA", 27.0, 246.0),
                    new ValueRanges(48, 83, "ap", CalculateType.CI95, "IgA", 29.0, 256.0),
                    new ValueRanges(84, 119, "ap", CalculateType.CI95, "IgA", 34.0, 274.0),
                    new ValueRanges(120, 155, "ap", CalculateType.CI95, "IgA", 42.0, 295.0),
                    new ValueRanges(156, 191, "ap", CalculateType.CI95, "IgA", 52.0, 319.0),
                    new ValueRanges(192, 215, "ap", CalculateType.CI95, "IgA", 60.0, 337.0),
                    new ValueRanges(216, Integer.MAX_VALUE, "ap", CalculateType.CI95, "IgA", 61.0, 356.0),






                    //TODO: cilv valuetype düzelt

                    new ValueRanges(0, 0, "cilv", CalculateType.CI95, "IgG", 700.0, 1300.0),
                    new ValueRanges(1, 3, "cilv", CalculateType.CI95, "IgG", 280.0, 750.0),
                    new ValueRanges(4, 6, "cilv", CalculateType.CI95, "IgG", 200.0, 1200.0),
                    new ValueRanges(7, 12, "cilv", CalculateType.CI95, "IgG", 300.0, 1500.0),
                    new ValueRanges(13, 35, "cilv", CalculateType.CI95, "IgG", 400.0, 1300.0),
                    new ValueRanges(36, 71, "cilv", CalculateType.CI95, "IgG", 600.0, 1500.0),
                    new ValueRanges(72, Integer.MAX_VALUE, "cilv", CalculateType.CI95, "IgG", 639.0, 1344.0),

                    new ValueRanges(0, 0, "cilv", CalculateType.CI95, "IgM", 5.0, 30.0),
                    new ValueRanges(1, 3, "cilv", CalculateType.CI95, "IgM", 15.0, 70.0),
                    new ValueRanges(4, 6, "cilv", CalculateType.CI95, "IgM", 10.0, 90.0),
                    new ValueRanges(7, 12, "cilv", CalculateType.CI95, "IgM", 25.0, 115.0),
                    new ValueRanges(13, 35, "cilv", CalculateType.CI95, "IgM", 30.0, 120.0),
                    new ValueRanges(36, 71, "cilv", CalculateType.CI95, "IgM", 22.0, 100.0),
                    new ValueRanges(72, Integer.MAX_VALUE, "cilv", CalculateType.CI95, "IgM", 56.0, 352.0),

                    new ValueRanges(0, 0, "cilv", CalculateType.CI95, "IgA", 0.0, 11.0),
                    new ValueRanges(1, 3, "cilv", CalculateType.CI95, "IgA", 6.0, 50.0),
                    new ValueRanges(4, 6, "cilv", CalculateType.CI95, "IgA", 8.0, 90.0),
                    new ValueRanges(7, 12, "cilv", CalculateType.CI95, "IgA", 16.0, 100.0),
                    new ValueRanges(13, 35, "cilv", CalculateType.CI95, "IgA", 20.0, 230.0),
                    new ValueRanges(36, 71, "cilv", CalculateType.CI95, "IgA", 50.0, 150.0),
                    new ValueRanges(72, Integer.MAX_VALUE, "cilv", CalculateType.CI95, "IgA", 70.0, 312.0),

                    new ValueRanges(0, 2, "cilv", CalculateType.CI95, "IgG1", 218.0, 496.0),
                    new ValueRanges(3, 5, "cilv", CalculateType.CI95, "IgG1", 143.0, 394.0),
                    new ValueRanges(6, 8, "cilv", CalculateType.CI95, "IgG1", 190.0, 388.0),
                    new ValueRanges(9, 23, "cilv", CalculateType.CI95, "IgG1", 286.0, 680.0),
                    new ValueRanges(24, 47, "cilv", CalculateType.CI95, "IgG1", 381.0, 884.0),
                    new ValueRanges(48, 71, "cilv", CalculateType.CI95, "IgG1", 292.0, 816.0),
                    new ValueRanges(72, 95, "cilv", CalculateType.CI95, "IgG1", 422.0, 802.0),
                    new ValueRanges(96, 119, "cilv", CalculateType.CI95, "IgG1", 456.0, 938.0),
                    new ValueRanges(120, 143, "cilv", CalculateType.CI95, "IgG1", 456.0, 952.0),
                    new ValueRanges(144, 167, "cilv", CalculateType.CI95, "IgG1", 347.0, 993.0),
                    new ValueRanges(168, Integer.MAX_VALUE, "cilv", CalculateType.CI95, "IgG1", 422.0, 1292.0),

                    new ValueRanges(0, 2, "cilv", CalculateType.CI95, "IgG2", 40.0, 167.0),
                    new ValueRanges(3, 5, "cilv", CalculateType.CI95, "IgG2", 23.0, 147.0),
                    new ValueRanges(6, 8, "cilv", CalculateType.CI95, "IgG2", 37.0, 60.0),
                    new ValueRanges(9, 23, "cilv", CalculateType.CI95, "IgG2", 30.0, 327.0),
                    new ValueRanges(24, 47, "cilv", CalculateType.CI95, "IgG2", 70.0, 443.0),
                    new ValueRanges(48, 71, "cilv", CalculateType.CI95, "IgG2", 83.0, 513.0),
                    new ValueRanges(72, 95, "cilv", CalculateType.CI95, "IgG2", 113.0, 480.0),
                    new ValueRanges(96, 119, "cilv", CalculateType.CI95, "IgG2", 163.0, 513.0),
                    new ValueRanges(120, 143, "cilv", CalculateType.CI95, "IgG2", 147.0, 493.0),
                    new ValueRanges(144, 167, "cilv", CalculateType.CI95, "IgG2", 140.0, 440.0),
                    new ValueRanges(168, Integer.MAX_VALUE, "cilv", CalculateType.CI95, "IgG2", 117.0, 747.0),

                    new ValueRanges(0, 2, "cilv", CalculateType.CI95, "IgG3", 4.0, 23.0),
                    new ValueRanges(3, 5, "cilv", CalculateType.CI95, "IgG3", 4.0, 100.0),
                    new ValueRanges(6, 8, "cilv", CalculateType.CI95, "IgG3", 12.0, 62.0),
                    new ValueRanges(9, 23, "cilv", CalculateType.CI95, "IgG3", 13.0, 82.0),
                    new ValueRanges(24, 47, "cilv", CalculateType.CI95, "IgG3", 17.0, 90.0),
                    new ValueRanges(48, 71, "cilv", CalculateType.CI95, "IgG3", 8.0, 111.0),
                    new ValueRanges(72, 95, "cilv", CalculateType.CI95, "IgG3", 15.0, 133.0),
                    new ValueRanges(96, 119, "cilv", CalculateType.CI95, "IgG3", 26.0, 113.0),
                    new ValueRanges(120, 143, "cilv", CalculateType.CI95, "IgG3", 12.0, 179.0),
                    new ValueRanges(144, 167, "cilv", CalculateType.CI95, "IgG3", 23.0, 117.0),
                    new ValueRanges(168, Integer.MAX_VALUE, "cilv", CalculateType.CI95, "IgG3", 41.0, 129.0),

                    new ValueRanges(0, 2, "cilv", CalculateType.CI95, "IgG4", 1.0, 120.0),
                    new ValueRanges(3, 5, "cilv", CalculateType.CI95, "IgG4", 1.0, 120.0),
                    new ValueRanges(6, 8, "cilv", CalculateType.CI95, "IgG4", 1.0, 120.0),
                    new ValueRanges(9, 23, "cilv", CalculateType.CI95, "IgG4", 1.0, 120.0),
                    new ValueRanges(24, 47, "cilv", CalculateType.CI95, "IgG4", 1.0, 120.0),
                    new ValueRanges(48, 71, "cilv", CalculateType.CI95, "IgG4", 2.0, 112.0),
                    new ValueRanges(72, 95, "cilv", CalculateType.CI95, "IgG4", 1.0, 138.0),
                    new ValueRanges(96, 119, "cilv", CalculateType.CI95, "IgG4", 1.0, 95.0),
                    new ValueRanges(120, 143, "cilv", CalculateType.CI95, "IgG4", 1.0, 153.0),
                    new ValueRanges(144, 167, "cilv", CalculateType.CI95, "IgG4", 1.0, 143.0),
                    new ValueRanges(168, Integer.MAX_VALUE, "cilv", CalculateType.CI95, "IgG4", 10.0, 67.0),





                    //TODO: os





                    //TODO: tjp G2 G3 G4 geo,full month fix

                    //IgG
                    new ValueRanges(0, 0, "tjp", CalculateType.GEOMETRIC, "IgG", 653.8, 1114.6),
                    new ValueRanges(0, 0, "tjp", CalculateType.MINMAX, "IgG", 492.0, 1190.0),
                    new ValueRanges(0, 0, "tjp", CalculateType.CI95, "IgG", 792.0, 1037.5),

                    new ValueRanges(1, 5, "tjp", CalculateType.GEOMETRIC, "IgG", 280.7, 667.0),
                    new ValueRanges(1, 5, "tjp", CalculateType.MINMAX, "IgG", 270.0, 792.0),
                    new ValueRanges(1, 5, "tjp", CalculateType.CI95, "IgG", 384.2, 629.7),

                    new ValueRanges(6, 8, "tjp", CalculateType.GEOMETRIC, "IgG", 374.0, 789.8),
                    new ValueRanges(6, 8, "tjp", CalculateType.MINMAX, "IgG", 268.0, 898.0),
                    new ValueRanges(6, 8, "tjp", CalculateType.CI95, "IgG", 515.6, 722.4),

                    new ValueRanges(9, 12, "tjp", CalculateType.GEOMETRIC, "IgG", 511.6, 873.8),
                    new ValueRanges(9, 12, "tjp", CalculateType.MINMAX, "IgG", 421.0, 1100.0),
                    new ValueRanges(9, 12, "tjp", CalculateType.CI95, "IgG", 641.9, 788.2),

                    new ValueRanges(13, 24, "tjp", CalculateType.GEOMETRIC, "IgG", 574.7, 974.1),
                    new ValueRanges(13, 24, "tjp", CalculateType.MINMAX, "IgG", 365.0, 1200.0),
                    new ValueRanges(13, 24, "tjp", CalculateType.CI95, "IgG", 748.2, 851.4),

                    new ValueRanges(25, 36, "tjp", CalculateType.GEOMETRIC, "IgG", 613.9, 1030.7),
                    new ValueRanges(25, 36, "tjp", CalculateType.MINMAX, "IgG", 430.0, 1290.0),
                    new ValueRanges(25, 36, "tjp", CalculateType.CI95, "IgG", 790.4, 906.4),

                    new ValueRanges(37, 48, "tjp", CalculateType.GEOMETRIC, "IgG", 722.7, 1037.1),
                    new ValueRanges(37, 48, "tjp", CalculateType.MINMAX, "IgG", 539.0, 1200.0),
                    new ValueRanges(37, 48, "tjp", CalculateType.CI95, "IgG", 844.1, 944.6),

                    new ValueRanges(49, 72, "tjp", CalculateType.GEOMETRIC, "IgG", 776.6, 1195.8),
                    new ValueRanges(49, 72, "tjp", CalculateType.MINMAX, "IgG", 528.0, 1490.0),
                    new ValueRanges(49, 72, "tjp", CalculateType.CI95, "IgG", 958.5, 1058.5),

                    new ValueRanges(7, 8, "tjp", CalculateType.GEOMETRIC, "IgG", 837.5, 1243.9),
                    new ValueRanges(7, 8, "tjp", CalculateType.MINMAX, "IgG", 527.0, 1590.0),
                    new ValueRanges(7, 8, "tjp", CalculateType.CI95, "IgG", 1011.5, 1111.4),

                    new ValueRanges(9, 10, "tjp", CalculateType.GEOMETRIC, "IgG", 824.0, 1301.6),
                    new ValueRanges(9, 10, "tjp", CalculateType.MINMAX, "IgG", 646.0, 1620.0),
                    new ValueRanges(9, 10, "tjp", CalculateType.CI95, "IgG", 1024.9, 1151.7),

                    new ValueRanges(11, 12, "tjp", CalculateType.GEOMETRIC, "IgG", 822.8, 1280.6),
                    new ValueRanges(11, 12, "tjp", CalculateType.MINMAX, "IgG", 579.0, 1610.0),
                    new ValueRanges(11, 12, "tjp", CalculateType.CI95, "IgG", 995.9, 1155.6),

                    new ValueRanges(13, 14, "tjp", CalculateType.GEOMETRIC, "IgG", 851.8, 1323.8),
                    new ValueRanges(13, 14, "tjp", CalculateType.MINMAX, "IgG", 741.0, 1650.0),
                    new ValueRanges(13, 14, "tjp", CalculateType.CI95, "IgG", 1014.2, 1209.0),

                    new ValueRanges(15, 16, "tjp", CalculateType.GEOMETRIC, "IgG", 773.4, 1188.8),
                    new ValueRanges(15, 16, "tjp", CalculateType.MINMAX, "IgG", 666.0, 1370.0),
                    new ValueRanges(15, 16, "tjp", CalculateType.CI95, "IgG", 895.3, 1108.9),

                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.GEOMETRIC, "IgG", 944.7, 1505.1),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.MINMAX, "IgG", 830.0, 1820.0),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.CI95, "IgG", 1109.9, 1398.0),


                    //IgA
                    new ValueRanges(0, 0, "tjp", CalculateType.GEOMETRIC, "IgA", 5.5, 5.9),
                    new ValueRanges(0, 0, "tjp", CalculateType.MINMAX, "IgA", 5.0, 5.8),
                    new ValueRanges(0, 0, "tjp", CalculateType.CI95, "IgA", 5.6, 5.9),

                    new ValueRanges(1, 5, "tjp", CalculateType.GEOMETRIC, "IgA", 0.5, 39.9),
                    new ValueRanges(1, 5, "tjp", CalculateType.MINMAX, "IgA", 5.8, 58.0),
                    new ValueRanges(1, 5, "tjp", CalculateType.CI95, "IgA", 15.8, 40.9),

                    new ValueRanges(6, 8, "tjp", CalculateType.GEOMETRIC, "IgA", -2.0, 48.4),
                    new ValueRanges(6, 8, "tjp", CalculateType.MINMAX, "IgA", 5.8, 85.8),
                    new ValueRanges(6, 8, "tjp", CalculateType.CI95, "IgA", 20.5, 48.5),

                    new ValueRanges(9, 12, "tjp", CalculateType.GEOMETRIC, "IgA", 16.2, 89.6),
                    new ValueRanges(9, 12, "tjp", CalculateType.MINMAX, "IgA", 18.4, 154.0),
                    new ValueRanges(9, 12, "tjp", CalculateType.CI95, "IgA", 47.2, 76.9),

                    new ValueRanges(13, 24, "tjp", CalculateType.GEOMETRIC, "IgA", 25.8, 62.4),
                    new ValueRanges(13, 24, "tjp", CalculateType.MINMAX, "IgA", 11.5, 94.3),
                    new ValueRanges(13, 24, "tjp", CalculateType.CI95, "IgA", 42.9, 52.6),

                    new ValueRanges(25, 36, "tjp", CalculateType.GEOMETRIC, "IgA", 26.7, 80.3),
                    new ValueRanges(25, 36, "tjp", CalculateType.MINMAX, "IgA", 23.0, 130.0),
                    new ValueRanges(25, 36, "tjp", CalculateType.CI95, "IgA", 51.4, 66.3),

                    new ValueRanges(37, 48, "tjp", CalculateType.GEOMETRIC, "IgA", 46.6, 91.0),
                    new ValueRanges(37, 48, "tjp", CalculateType.MINMAX, "IgA", 40.7, 115.0),
                    new ValueRanges(37, 48, "tjp", CalculateType.CI95, "IgA", 64.8, 79.2),

                    new ValueRanges(49, 72, "tjp", CalculateType.GEOMETRIC, "IgA", 54.5, 129.3),
                    new ValueRanges(49, 72, "tjp", CalculateType.MINMAX, "IgA", 23.0, 205.1),
                    new ValueRanges(49, 72, "tjp", CalculateType.CI95, "IgA", 90.2, 108.3),

                    new ValueRanges(7, 8, "tjp", CalculateType.GEOMETRIC, "IgA", 66.1, 150.7),
                    new ValueRanges(7, 8, "tjp", CalculateType.MINMAX, "IgA", 36.1, 268.0),
                    new ValueRanges(7, 8, "tjp", CalculateType.CI95, "IgA", 105.9, 127.0),

                    new ValueRanges(9, 10, "tjp", CalculateType.GEOMETRIC, "IgA", 70.8, 162.6),
                    new ValueRanges(9, 10, "tjp", CalculateType.MINMAX, "IgA", 54.0, 268.0),
                    new ValueRanges(9, 10, "tjp", CalculateType.CI95, "IgA", 111.8, 137.0),

                    new ValueRanges(11, 12, "tjp", CalculateType.GEOMETRIC, "IgA", 72.8, 158.8),
                    new ValueRanges(11, 12, "tjp", CalculateType.MINMAX, "IgA", 27.0, 198.0),
                    new ValueRanges(11, 12, "tjp", CalculateType.CI95, "IgA", 109.7, 141.3),

                    new ValueRanges(13, 14, "tjp", CalculateType.GEOMETRIC, "IgA", 83.1, 177.9),
                    new ValueRanges(13, 14, "tjp", CalculateType.MINMAX, "IgA", 52.4, 225.0),
                    new ValueRanges(13, 14, "tjp", CalculateType.CI95, "IgA", 118.0, 159.0),

                    new ValueRanges(15, 16, "tjp", CalculateType.GEOMETRIC, "IgA", 80.4, 139.2),
                    new ValueRanges(15, 16, "tjp", CalculateType.MINMAX, "IgA", 48.0, 158.0),
                    new ValueRanges(15, 16, "tjp", CalculateType.CI95, "IgA", 97.8, 130.3),

                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.GEOMETRIC, "IgA", 65.8, 177.1),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.MINMAX, "IgA", 46.5, 221.0),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.CI95, "IgA", 102.4, 163.8),

                    //IgM
                    new ValueRanges(0, 0, "tjp", CalculateType.GEOMETRIC, "IgM", 15.0, 22.0),
                    new ValueRanges(0, 0, "tjp", CalculateType.MINMAX, "IgM", 17.3, 29.6),
                    new ValueRanges(0, 0, "tjp", CalculateType.CI95, "IgM", 16.7, 20.7),

                    new ValueRanges(1, 5, "tjp", CalculateType.GEOMETRIC, "IgM", 19.9, 94.7),
                    new ValueRanges(1, 5, "tjp", CalculateType.MINMAX, "IgM", 18.4, 145.0),
                    new ValueRanges(1, 5, "tjp", CalculateType.CI95, "IgM", 41.9, 92.1),

                    new ValueRanges(6, 8, "tjp", CalculateType.GEOMETRIC, "IgM", 29.8, 107.6),
                    new ValueRanges(6, 8, "tjp", CalculateType.MINMAX, "IgM", 26.4, 146.0),
                    new ValueRanges(6, 8, "tjp", CalculateType.CI95, "IgM", 58.5, 98.5),

                    new ValueRanges(9, 12, "tjp", CalculateType.GEOMETRIC, "IgM", 45.8, 126.4),
                    new ValueRanges(9, 12, "tjp", CalculateType.MINMAX, "IgM", 23.5, 180.0),
                    new ValueRanges(9, 12, "tjp", CalculateType.CI95, "IgM", 78.9, 110.8),

                    new ValueRanges(13, 24, "tjp", CalculateType.GEOMETRIC, "IgM", 58.0, 138.6),
                    new ValueRanges(13, 24, "tjp", CalculateType.MINMAX, "IgM", 25.6, 201.0),
                    new ValueRanges(13, 24, "tjp", CalculateType.CI95, "IgM", 96.3, 117.7),

                    new ValueRanges(25, 36, "tjp", CalculateType.GEOMETRIC, "IgM", 58.6, 126.4),
                    new ValueRanges(25, 36, "tjp", CalculateType.MINMAX, "IgM", 36.0, 199.0),
                    new ValueRanges(25, 36, "tjp", CalculateType.CI95, "IgM", 89.0, 107.7),

                    new ValueRanges(37, 48, "tjp", CalculateType.GEOMETRIC, "IgM", 50.8, 121.4),
                    new ValueRanges(37, 48, "tjp", CalculateType.MINMAX, "IgM", 26.1, 188.0),
                    new ValueRanges(37, 48, "tjp", CalculateType.CI95, "IgM", 80.9, 104.0),

                    new ValueRanges(49, 72, "tjp", CalculateType.GEOMETRIC, "IgM", 65.0, 146.6),
                    new ValueRanges(49, 72, "tjp", CalculateType.MINMAX, "IgM", 33.3, 207.0),
                    new ValueRanges(49, 72, "tjp", CalculateType.CI95, "IgM", 103.7, 123.3),

                    new ValueRanges(7, 8, "tjp", CalculateType.GEOMETRIC, "IgM", 54.7, 140.5),
                    new ValueRanges(7, 8, "tjp", CalculateType.MINMAX, "IgM", 30.5, 220.0),
                    new ValueRanges(7, 8, "tjp", CalculateType.CI95, "IgM", 95.5, 116.8),

                    new ValueRanges(9, 10, "tjp", CalculateType.GEOMETRIC, "IgM", 44.6, 143.2),
                    new ValueRanges(9, 10, "tjp", CalculateType.MINMAX, "IgM", 33.7, 257.0),
                    new ValueRanges(9, 10, "tjp", CalculateType.CI95, "IgM", 90.8, 118.0),

                    new ValueRanges(11, 12, "tjp", CalculateType.GEOMETRIC, "IgM", 63.6, 141.2),
                    new ValueRanges(11, 12, "tjp", CalculateType.MINMAX, "IgM", 30.0, 187.0),
                    new ValueRanges(11, 12, "tjp", CalculateType.CI95, "IgM", 96.0, 124.0),

                    new ValueRanges(13, 14, "tjp", CalculateType.GEOMETRIC, "IgM", 77.1, 164.7),
                    new ValueRanges(13, 14, "tjp", CalculateType.MINMAX, "IgM", 44.0, 206.0),
                    new ValueRanges(13, 14, "tjp", CalculateType.CI95, "IgM", 110.3, 147.3),

                    new ValueRanges(15, 16, "tjp", CalculateType.GEOMETRIC, "IgM", 50.0, 149.4),
                    new ValueRanges(15, 16, "tjp", CalculateType.MINMAX, "IgM", 33.0, 205.0),
                    new ValueRanges(15, 16, "tjp", CalculateType.CI95, "IgM", 83.7, 138.8),

                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.GEOMETRIC, "IgM", 86.4, 175.4),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.MINMAX, "IgM", 75.0, 198.5),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.CI95, "IgM", 114.6, 161.9),

                    //IgG1
                    new ValueRanges(0, 0, "tjp", CalculateType.GEOMETRIC, "IgG1", 523.0, 827.0),
                    new ValueRanges(0, 0, "tjp", CalculateType.MINMAX, "IgG1", 430.0, 897.0),
                    new ValueRanges(0, 0, "tjp", CalculateType.CI95, "IgG1", 611.0, 773.0),

                    new ValueRanges(1, 5, "tjp", CalculateType.GEOMETRIC, "IgG1", 206.0, 432.0),
                    new ValueRanges(1, 5, "tjp", CalculateType.MINMAX, "IgG1", 160.0, 574.0),
                    new ValueRanges(1, 5, "tjp", CalculateType.CI95, "IgG1", 261.0, 413.0),

                    new ValueRanges(6, 8, "tjp", CalculateType.GEOMETRIC, "IgG1", 297.0, 673.0),
                    new ValueRanges(6, 8, "tjp", CalculateType.MINMAX, "IgG1", 279.0, 820.0),
                    new ValueRanges(6, 8, "tjp", CalculateType.CI95, "IgG1", 408.0, 625.0),

                    new ValueRanges(9, 12, "tjp", CalculateType.GEOMETRIC, "IgG1", 322.0, 802.0),
                    new ValueRanges(9, 12, "tjp", CalculateType.MINMAX, "IgG1", 328.0, 1250.0),
                    new ValueRanges(9, 12, "tjp", CalculateType.CI95, "IgG1", 506.0, 690.0),

                    new ValueRanges(13, 24, "tjp", CalculateType.GEOMETRIC, "IgG1", 429.0, 1013.0),
                    new ValueRanges(13, 24, "tjp", CalculateType.MINMAX, "IgG1", 344.0, 1435.0),
                    new ValueRanges(13, 24, "tjp", CalculateType.CI95, "IgG1", 702.0, 844.0),

                    new ValueRanges(25, 36, "tjp", CalculateType.GEOMETRIC, "IgG1", 451.0, 1021.0),
                    new ValueRanges(25, 36, "tjp", CalculateType.MINMAX, "IgG1", 340.0, 1470.0),
                    new ValueRanges(25, 36, "tjp", CalculateType.CI95, "IgG1", 712.0, 860.0),

                    new ValueRanges(37, 48, "tjp", CalculateType.GEOMETRIC, "IgG1", 516.0, 1008.0),
                    new ValueRanges(37, 48, "tjp", CalculateType.MINMAX, "IgG1", 439.0, 1333.0),
                    new ValueRanges(37, 48, "tjp", CalculateType.CI95, "IgG1", 726.0, 867.0),

                    new ValueRanges(49, 72, "tjp", CalculateType.GEOMETRIC, "IgG1", 546.0, 964.0),
                    new ValueRanges(49, 72, "tjp", CalculateType.MINMAX, "IgG1", 468.0, 1333.0),
                    new ValueRanges(49, 72, "tjp", CalculateType.CI95, "IgG1", 726.0, 837.0),

                    new ValueRanges(7, 8, "tjp", CalculateType.GEOMETRIC, "IgG1", 525.0, 1087.0),
                    new ValueRanges(7, 8, "tjp", CalculateType.MINMAX, "IgG1", 420.0, 1470.0),
                    new ValueRanges(7, 8, "tjp", CalculateType.CI95, "IgG1", 778.0, 920.0),

                    new ValueRanges(9, 10, "tjp", CalculateType.GEOMETRIC, "IgG1", 531.0, 1189.0),
                    new ValueRanges(9, 10, "tjp", CalculateType.MINMAX, "IgG1", 380.0, 1840.0),
                    new ValueRanges(9, 10, "tjp", CalculateType.CI95, "IgG1", 834.0, 996.0),

                    new ValueRanges(11, 12, "tjp", CalculateType.GEOMETRIC, "IgG1", 601.0, 1083.0),
                    new ValueRanges(11, 12, "tjp", CalculateType.MINMAX, "IgG1", 599.0, 1560.0),
                    new ValueRanges(11, 12, "tjp", CalculateType.CI95, "IgG1", 787.0, 953.0),

                    new ValueRanges(13, 14, "tjp", CalculateType.GEOMETRIC, "IgG1", 518.0, 1226.0),
                    new ValueRanges(13, 14, "tjp", CalculateType.MINMAX, "IgG1", 490.0, 1560.0),
                    new ValueRanges(13, 14, "tjp", CalculateType.CI95, "IgG1", 805.0, 1061.0),

                    new ValueRanges(15, 16, "tjp", CalculateType.GEOMETRIC, "IgG1", 527.0, 1065.0),
                    new ValueRanges(15, 16, "tjp", CalculateType.MINMAX, "IgG1", 498.0, 1460.0),
                    new ValueRanges(15, 16, "tjp", CalculateType.CI95, "IgG1", 711.0, 956.0),

                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.GEOMETRIC, "IgG1", 643.0, 1071.0),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.MINMAX, "IgG1", 528.0, 1384.0),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.CI95, "IgG1", 782.0, 978.0),

                    //IgG2

                    new ValueRanges(0, 0, "tjp", CalculateType.GEOMETRIC, "IgG2", 523.0, 827.0),
                    new ValueRanges(0, 0, "tjp", CalculateType.MINMAX, "IgG2", 87.0, 263.0),
                    new ValueRanges(0, 0, "tjp", CalculateType.CI95, "IgG2", 135.0, 192.0),

                    new ValueRanges(1, 5, "tjp", CalculateType.GEOMETRIC, "IgG2", 206.0, 432.0),
                    new ValueRanges(1, 5, "tjp", CalculateType.MINMAX, "IgG2", 32.0, 108.0),
                    new ValueRanges(1, 5, "tjp", CalculateType.CI95, "IgG2", 46.0, 84.0),

                    new ValueRanges(6, 8, "tjp", CalculateType.GEOMETRIC, "IgG2", 297.0, 673.0),
                    new ValueRanges(6, 8, "tjp", CalculateType.MINMAX, "IgG2", 36.0, 146.0),
                    new ValueRanges(6, 8, "tjp", CalculateType.CI95, "IgG2", 53.0, 97.0),

                    new ValueRanges(9, 12, "tjp", CalculateType.GEOMETRIC, "IgG2", 322.0, 802.0),
                    new ValueRanges(9, 12, "tjp", CalculateType.MINMAX, "IgG2", 25.0, 161.0),
                    new ValueRanges(9, 12, "tjp", CalculateType.CI95, "IgG2", 58.0, 85.0),

                    new ValueRanges(13, 24, "tjp", CalculateType.GEOMETRIC, "IgG2", 429.0, 1013.0),
                    new ValueRanges(13, 24, "tjp", CalculateType.MINMAX, "IgG2", 31.0, 264.0),
                    new ValueRanges(13, 24, "tjp", CalculateType.CI95, "IgG2", 92.0, 116.0),

                    new ValueRanges(25, 36, "tjp", CalculateType.GEOMETRIC, "IgG2", 451.0, 1021.0),
                    new ValueRanges(25, 36, "tjp", CalculateType.MINMAX, "IgG2", 43.0, 380.0),
                    new ValueRanges(25, 36, "tjp", CalculateType.CI95, "IgG2", 112.0, 157.0),

                    new ValueRanges(37, 48, "tjp", CalculateType.GEOMETRIC, "IgG2", 516.0, 1008.0),
                    new ValueRanges(37, 48, "tjp", CalculateType.MINMAX, "IgG2", 60.0, 410.0),
                    new ValueRanges(37, 48, "tjp", CalculateType.CI95, "IgG2", 155.0, 211.0),

                    new ValueRanges(49, 72, "tjp", CalculateType.GEOMETRIC, "IgG2", 546.0, 964.0),
                    new ValueRanges(49, 72, "tjp", CalculateType.MINMAX, "IgG2", 85.0, 440.0),
                    new ValueRanges(49, 72, "tjp", CalculateType.CI95, "IgG2", 160.0, 204.0),

                    new ValueRanges(7, 8, "tjp", CalculateType.GEOMETRIC, "IgG2", 525.0, 1087.0),
                    new ValueRanges(7, 8, "tjp", CalculateType.MINMAX, "IgG2", 67.0, 460.0),
                    new ValueRanges(7, 8, "tjp", CalculateType.CI95, "IgG2", 193.0, 245.0),

                    new ValueRanges(9, 10, "tjp", CalculateType.GEOMETRIC, "IgG2", 531.0, 1189.0),
                    new ValueRanges(9, 10, "tjp", CalculateType.MINMAX, "IgG2", 70.0, 543.0),
                    new ValueRanges(9, 10, "tjp", CalculateType.CI95, "IgG2", 211.0, 273.0),

                    new ValueRanges(11, 12, "tjp", CalculateType.GEOMETRIC, "IgG2", 601.0, 1083.0),
                    new ValueRanges(11, 12, "tjp", CalculateType.MINMAX, "IgG2", 111.0, 515.0),
                    new ValueRanges(11, 12, "tjp", CalculateType.CI95, "IgG2", 195.0, 259.0),

                    new ValueRanges(13, 14, "tjp", CalculateType.GEOMETRIC, "IgG2", 518.0, 1226.0),
                    new ValueRanges(13, 14, "tjp", CalculateType.MINMAX, "IgG2", 100.0, 573.0),
                    new ValueRanges(13, 14, "tjp", CalculateType.CI95, "IgG2", 257.0, 361.0),

                    new ValueRanges(15, 16, "tjp", CalculateType.GEOMETRIC, "IgG2", 527.0, 1065.0),
                    new ValueRanges(15, 16, "tjp", CalculateType.MINMAX, "IgG2", 110.0, 398.0),
                    new ValueRanges(15, 16, "tjp", CalculateType.CI95, "IgG2", 214.0, 292.0),

                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.GEOMETRIC, "IgG2", 643.0, 1071.0),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.MINMAX, "IgG2", 147.0, 610.0),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.CI95, "IgG2", 271.0, 391.0),

                    //IgG3

                    new ValueRanges(0, 0, "tjp", CalculateType.GEOMETRIC, "IgG3", 523.0, 827.0),
                    new ValueRanges(0, 0, "tjp", CalculateType.MINMAX, "IgG3", 18.0, 78.0),
                    new ValueRanges(0, 0, "tjp", CalculateType.CI95, "IgG3", 31.0, 50.0),

                    new ValueRanges(1, 5, "tjp", CalculateType.GEOMETRIC, "IgG3", 206.0, 432.0),
                    new ValueRanges(1, 5, "tjp", CalculateType.MINMAX, "IgG3", 13.0, 53.0),
                    new ValueRanges(1, 5, "tjp", CalculateType.CI95, "IgG3", 17.0, 35.0),

                    new ValueRanges(6, 8, "tjp", CalculateType.GEOMETRIC, "IgG3", 297.0, 673.0),
                    new ValueRanges(6, 8, "tjp", CalculateType.MINMAX, "IgG3", 14.0, 100.0),
                    new ValueRanges(6, 8, "tjp", CalculateType.CI95, "IgG3", 27.0, 56.0),

                    new ValueRanges(9, 12, "tjp", CalculateType.GEOMETRIC, "IgG3", 322.0, 802.0),
                    new ValueRanges(9, 12, "tjp", CalculateType.MINMAX, "IgG3", 18.0, 110.0),
                    new ValueRanges(9, 12, "tjp", CalculateType.CI95, "IgG3", 34.0, 53.0),

                    new ValueRanges(13, 24, "tjp", CalculateType.GEOMETRIC, "IgG3", 429.0, 1013.0),
                    new ValueRanges(13, 24, "tjp", CalculateType.MINMAX, "IgG3", 16.0, 132.0),
                    new ValueRanges(13, 24, "tjp", CalculateType.CI95, "IgG3", 37.0, 49.0),

                    new ValueRanges(25, 36, "tjp", CalculateType.GEOMETRIC, "IgG3", 451.0, 1021.0),
                    new ValueRanges(25, 36, "tjp", CalculateType.MINMAX, "IgG3", 14.0, 125.0),
                    new ValueRanges(25, 36, "tjp", CalculateType.CI95, "IgG3", 30.0, 42.0),

                    new ValueRanges(37, 48, "tjp", CalculateType.GEOMETRIC, "IgG3", 516.0, 1008.0),
                    new ValueRanges(37, 48, "tjp", CalculateType.MINMAX, "IgG3", 15.0, 120.0),
                    new ValueRanges(37, 48, "tjp", CalculateType.CI95, "IgG3", 35.0, 50.0),

                    new ValueRanges(49, 72, "tjp", CalculateType.GEOMETRIC, "IgG3", 546.0, 964.0),
                    new ValueRanges(49, 72, "tjp", CalculateType.MINMAX, "IgG3", 15.0, 107.0),
                    new ValueRanges(49, 72, "tjp", CalculateType.CI95, "IgG3", 36.0, 47.0),

                    new ValueRanges(7, 8, "tjp", CalculateType.GEOMETRIC, "IgG3", 525.0, 1087.0),
                    new ValueRanges(7, 8, "tjp", CalculateType.MINMAX, "IgG3", 21.0, 186.0),
                    new ValueRanges(7, 8, "tjp", CalculateType.CI95, "IgG3", 51.0, 73.0),

                    new ValueRanges(9, 10, "tjp", CalculateType.GEOMETRIC, "IgG3", 531.0, 1189.0),
                    new ValueRanges(9, 10, "tjp", CalculateType.MINMAX, "IgG3", 20.0, 186.0),
                    new ValueRanges(9, 10, "tjp", CalculateType.CI95, "IgG3", 50.0, 67.0),

                    new ValueRanges(11, 12, "tjp", CalculateType.GEOMETRIC, "IgG3", 601.0, 1083.0),
                    new ValueRanges(11, 12, "tjp", CalculateType.MINMAX, "IgG3", 29.0, 200.0),
                    new ValueRanges(11, 12, "tjp", CalculateType.CI95, "IgG3", 47.0, 75.0),

                    new ValueRanges(13, 14, "tjp", CalculateType.GEOMETRIC, "IgG3", 518.0, 1226.0),
                    new ValueRanges(13, 14, "tjp", CalculateType.MINMAX, "IgG3", 28.0, 223.0),
                    new ValueRanges(13, 14, "tjp", CalculateType.CI95, "IgG3", 73.0, 117.0),

                    new ValueRanges(15, 16, "tjp", CalculateType.GEOMETRIC, "IgG3", 527.0, 1065.0),
                    new ValueRanges(15, 16, "tjp", CalculateType.MINMAX, "IgG3", 30.0, 120.0),
                    new ValueRanges(15, 16, "tjp", CalculateType.CI95, "IgG3", 51.0, 73.0),

                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.GEOMETRIC, "IgG3", 643.0, 1071.0),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.MINMAX, "IgG3", 21.0, 152.0),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.CI95, "IgG3", 43.0, 73.0),


                    //IgG4

                    new ValueRanges(0, 0, "tjp", CalculateType.GEOMETRIC, "IgG4", 523.0, 827.0),
                    new ValueRanges(0, 0, "tjp", CalculateType.MINMAX, "IgG4", 17.0, 81.0),
                    new ValueRanges(0, 0, "tjp", CalculateType.CI95, "IgG4", 17.0, 36.0),

                    new ValueRanges(1, 5, "tjp", CalculateType.GEOMETRIC, "IgG4", 206.0, 432.0),
                    new ValueRanges(1, 5, "tjp", CalculateType.MINMAX, "IgG4", 2.0, 48.0),
                    new ValueRanges(1, 5, "tjp", CalculateType.CI95, "IgG4", 10.0, 31.0),

                    new ValueRanges(6, 8, "tjp", CalculateType.GEOMETRIC, "IgG4", 297.0, 673.0),
                    new ValueRanges(6, 8, "tjp", CalculateType.MINMAX, "IgG4", 2.0, 52.0),
                    new ValueRanges(6, 8, "tjp", CalculateType.CI95, "IgG4", 12.0, 25.0),

                    new ValueRanges(9, 12, "tjp", CalculateType.GEOMETRIC, "IgG4", 322.0, 802.0),
                    new ValueRanges(9, 12, "tjp", CalculateType.MINMAX, "IgG4", 2.0, 20.0),
                    new ValueRanges(9, 12, "tjp", CalculateType.CI95, "IgG4", 12.0, 16.0),

                    new ValueRanges(13, 24, "tjp", CalculateType.GEOMETRIC, "IgG4", 429.0, 1013.0),
                    new ValueRanges(13, 24, "tjp", CalculateType.MINMAX, "IgG4", 2.0, 99.0),
                    new ValueRanges(13, 24, "tjp", CalculateType.CI95, "IgG4", 18.0, 26.0),

                    new ValueRanges(25, 36, "tjp", CalculateType.GEOMETRIC, "IgG4", 451.0, 1021.0),
                    new ValueRanges(25, 36, "tjp", CalculateType.MINMAX, "IgG4", 2.0, 171.0),
                    new ValueRanges(25, 36, "tjp", CalculateType.CI95, "IgG4", 23.0, 43.0),

                    new ValueRanges(37, 48, "tjp", CalculateType.GEOMETRIC, "IgG4", 516.0, 1008.0),
                    new ValueRanges(37, 48, "tjp", CalculateType.MINMAX, "IgG4", 4.0, 185.0),
                    new ValueRanges(37, 48, "tjp", CalculateType.CI95, "IgG4", 27.0, 48.0),

                    new ValueRanges(49, 72, "tjp", CalculateType.GEOMETRIC, "IgG4", 546.0, 964.0),
                    new ValueRanges(49, 72, "tjp", CalculateType.MINMAX, "IgG4", 8.0, 227.0),
                    new ValueRanges(49, 72, "tjp", CalculateType.CI95, "IgG4", 37.0, 62.0),

                    new ValueRanges(7, 8, "tjp", CalculateType.GEOMETRIC, "IgG4", 525.0, 1087.0),
                    new ValueRanges(7, 8, "tjp", CalculateType.MINMAX, "IgG4", 2.0, 198.0),
                    new ValueRanges(7, 8, "tjp", CalculateType.CI95, "IgG4", 49.0, 72.0),

                    new ValueRanges(9, 10, "tjp", CalculateType.GEOMETRIC, "IgG4", 531.0, 1189.0),
                    new ValueRanges(9, 10, "tjp", CalculateType.MINMAX, "IgG4", 5.0, 202.0),
                    new ValueRanges(9, 10, "tjp", CalculateType.CI95, "IgG4", 41.0, 63.0),

                    new ValueRanges(11, 12, "tjp", CalculateType.GEOMETRIC, "IgG4", 601.0, 1083.0),
                    new ValueRanges(11, 12, "tjp", CalculateType.MINMAX, "IgG4", 4.0, 160.0),
                    new ValueRanges(11, 12, "tjp", CalculateType.CI95, "IgG4", 34.0, 64.0),

                    new ValueRanges(13, 14, "tjp", CalculateType.GEOMETRIC, "IgG4", 518.0, 1226.0),
                    new ValueRanges(13, 14, "tjp", CalculateType.MINMAX, "IgG4", 10.0, 144.0),
                    new ValueRanges(13, 14, "tjp", CalculateType.CI95, "IgG4", 51.0, 84.0),

                    new ValueRanges(15, 16, "tjp", CalculateType.GEOMETRIC, "IgG4", 527.0, 1065.0),
                    new ValueRanges(15, 16, "tjp", CalculateType.MINMAX, "IgG4", 9.0, 187.0),
                    new ValueRanges(15, 16, "tjp", CalculateType.CI95, "IgG4", 30.0, 72.0),

                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.GEOMETRIC, "IgG4", 643.0, 1071.0),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.MINMAX, "IgG4", 15.0, 202.0),
                    new ValueRanges(17, Integer.MAX_VALUE, "tjp", CalculateType.CI95, "IgG4", 25.0, 66.0),





                    //TODO: turkjmedsci month düzelt


                    new ValueRanges(0,0, "turkjmedsci",CalculateType.GEOMETRIC, "IgG",651.66,1176.04),
                    new ValueRanges(1,3,"turkjmedsci", CalculateType.GEOMETRIC,"IgG",264.27,555.45),
                    new ValueRanges(4,6,"turkjmedsci", CalculateType.GEOMETRIC, "IgG",203.37,676.8),
                    new ValueRanges(7,12, "turkjmedsci",CalculateType.GEOMETRIC, "IgG",350.17,723.41),
                    new ValueRanges(13,24,"turkjmedsci", CalculateType.GEOMETRIC, "IgG",488.18,965.4),
                    new ValueRanges(25,35,"turkjmedsci", CalculateType.GEOMETRIC, "IgG",537.27,1035.55),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.GEOMETRIC, "IgG",659.0,987.38),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.GEOMETRIC, "IgG",727.33,1238.39),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.GEOMETRIC, "IgG",693.85,1338.39),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.GEOMETRIC, "IgG",919.73,1327.39),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.GEOMETRIC, "IgG",915.31,1639.09),

                    new ValueRanges(0,0,"turkjmedsci", CalculateType.MEAN, "IgG",690.81,1215.19),
                    new ValueRanges(1,3,"turkjmedsci", CalculateType.MEAN,"IgG",283.91,575.09),
                    new ValueRanges(4,6,"turkjmedsci", CalculateType.MEAN, "IgG",245.63,719.23),
                    new ValueRanges(7,12,"turkjmedsci", CalculateType.MEAN, "IgG",382.35,755.59),
                    new ValueRanges(13,24,"turkjmedsci", CalculateType.MEAN, "IgG",523.09,1000.31),
                    new ValueRanges(25,35,"turkjmedsci", CalculateType.MEAN, "IgG",562.36,1060.64),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.MEAN, "IgG",675.68,1004.06),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.MEAN, "IgG",759.40,1270.46),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.MEAN, "IgG",733.16,1377.70),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.MEAN, "IgG",938.24,1345.90),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.MEAN, "IgG",960.88,1684.66),

                    new ValueRanges(0,0,"turkjmedsci", CalculateType.MINMAX, "IgG",399.0,1480.0),
                    new ValueRanges(1,3,"turkjmedsci", CalculateType.MINMAX,"IgG",217.0,981.0),
                    new ValueRanges(4,6,"turkjmedsci", CalculateType.MINMAX, "IgG",270.0,1110.0),
                    new ValueRanges(7,12,"turkjmedsci", CalculateType.MINMAX, "IgG",242.0,977.0),
                    new ValueRanges(13,24,"turkjmedsci", CalculateType.MINMAX, "IgG",389.0,1260.0),
                    new ValueRanges(25,35,"turkjmedsci", CalculateType.MINMAX, "IgG",486.0,1970.0),
                    new ValueRanges(36,60, "turkjmedsci",CalculateType.MINMAX, "IgG",457.0,1120.0),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.MINMAX, "IgG",483.0,1580.0),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.MINMAX, "IgG",642.0,2290.0),
                    new ValueRanges(144,191, "turkjmedsci",CalculateType.MINMAX, "IgG",636.0,1610.0),
                    new ValueRanges(192,216, "turkjmedsci",CalculateType.MINMAX, "IgG",688.0,2430.0),

                    new ValueRanges(0,0,"turkjmedsci", CalculateType.CI95, "IgG",855.1,1050.9),
                    new ValueRanges(1,3,"turkjmedsci", CalculateType.CI95,"IgG",375.14,483.86),
                    new ValueRanges(4,6,"turkjmedsci", CalculateType.CI95, "IgG",394.01,570.86),
                    new ValueRanges(7,12,"turkjmedsci", CalculateType.CI95, "IgG",499.28,638.65),
                    new ValueRanges(13,24,"turkjmedsci", CalculateType.CI95, "IgG",672.6,850.8),
                    new ValueRanges(25,35,"turkjmedsci", CalculateType.CI95, "IgG",718.47,904.53),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.CI95, "IgG",778.56,901.18),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.CI95, "IgG",919.52,1110.35),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.CI95, "IgG",935.09,1175.77),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.CI95, "IgG",1065.96,1218.18),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.CI95, "IgG",1187.63,1457.9),


                    new ValueRanges(25,35, "turkjmedsci",CalculateType.GEOMETRIC, "IgG1",318.70,702.78),
                    new ValueRanges(36,60, "turkjmedsci",CalculateType.GEOMETRIC, "IgG1",424.45,589.01),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.GEOMETRIC, "IgG1",446.30,689.58),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.GEOMETRIC, "IgG1",417.78,850.56),
                    new ValueRanges(144,191, "turkjmedsci",CalculateType.GEOMETRIC, "IgG1",504.51,766.53),
                    new ValueRanges(192,216, "turkjmedsci",CalculateType.GEOMETRIC, "IgG1",415.73,874.97),


                    new ValueRanges(25,35, "turkjmedsci",CalculateType.MEAN, "IgG1",339.66,723.74),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.MEAN, "IgG1",431.65,596.21),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.MEAN, "IgG1",459.36,702.64),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.MEAN, "IgG1",443.84,876.62),
                    new ValueRanges(144,191, "turkjmedsci",CalculateType.MEAN, "IgG1",517.52,779.54),
                    new ValueRanges(192,216, "turkjmedsci",CalculateType.MEAN, "IgG1",444.88,904.12),


                    new ValueRanges(25,35,"turkjmedsci", CalculateType.MINMAX, "IgG1",309.0,1450.0),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.MINMAX, "IgG1",273.0,679.0),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.MINMAX, "IgG1",292.0,781.0),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.MINMAX, "IgG1",410.0,1530.0),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.MINMAX, "IgG1",344.0,958.0),
                    new ValueRanges(192,216, "turkjmedsci",CalculateType.MINMAX, "IgG1",403.0,958.0),


                    new ValueRanges(25,35,"turkjmedsci", CalculateType.CI95, "IgG1",459.98,603.41),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.CI95, "IgG1",483.20,544.65),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.CI95, "IgG1",535.87,626.72),
                    new ValueRanges(108,132, "turkjmedsci",CalculateType.CI95, "IgG1",579.43,741.03),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.CI95, "IgG1",599.61,697.45),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.CI95, "IgG1",588.75,760.24),


                    new ValueRanges(25,35, "turkjmedsci",CalculateType.GEOMETRIC, "IgG2",99.29,176.47),
                    new ValueRanges(36,60, "turkjmedsci",CalculateType.GEOMETRIC, "IgG2",93.12,194.72),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.GEOMETRIC, "IgG2",110.16,282.98),
                    new ValueRanges(108,132, "turkjmedsci",CalculateType.GEOMETRIC, "IgG2",164.95,336.39),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.GEOMETRIC, "IgG2",192.48,330.76),
                    new ValueRanges(192,216, "turkjmedsci",CalculateType.GEOMETRIC, "IgG2",243.93,475.59),


                    new ValueRanges(25,35,"turkjmedsci", CalculateType.MEAN, "IgG2",103.39,180.57),
                    new ValueRanges(36,60, "turkjmedsci",CalculateType.MEAN, "IgG2",101.15,202.75),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.MEAN, "IgG2",127.26,300.08),
                    new ValueRanges(108,132, "turkjmedsci",CalculateType.MEAN, "IgG2",179.84,351.28),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.MEAN, "IgG2",201.09,339.37),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.MEAN, "IgG2",260.07,491.73),


                    new ValueRanges(25,35,"turkjmedsci", CalculateType.MINMAX, "IgG2",87.6,289.0),
                    new ValueRanges(36,60, "turkjmedsci",CalculateType.MINMAX, "IgG2",73.3,271.0),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.MINMAX, "IgG2",88.1,408.0),
                    new ValueRanges(108,132,"turkjmedsci",CalculateType.MINMAX, "IgG2",81.0,442.0),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.MINMAX, "IgG2",159.0,406.0),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.MINMAX, "IgG2",184.0,696.0),


                    new ValueRanges(25,35,"turkjmedsci", CalculateType.CI95, "IgG2",127.57,156.39),
                    new ValueRanges(36,60, "turkjmedsci",CalculateType.CI95, "IgG2",132.98,170.92),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.CI95, "IgG2",181.40,245.93),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.CI95, "IgG2",233.55,297.57),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.CI95, "IgG2",244.41,296.05),
                    new ValueRanges(192,216, "turkjmedsci",CalculateType.CI95, "IgG2",332.6,419.15),


                    new ValueRanges(25,35,"turkjmedsci", CalculateType.GEOMETRIC, "IgG3",31.88,65.68),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.GEOMETRIC, "IgG3",22.50,65.60),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.GEOMETRIC, "IgG3",26.27,87.37),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.GEOMETRIC, "IgG3",40.22,114.96),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.GEOMETRIC, "IgG3",43.44,107.16),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.GEOMETRIC, "IgG3",43.04,129.62),


                    new ValueRanges(25,35,"turkjmedsci", CalculateType.MEAN, "IgG3",34.83,68.63),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.MEAN, "IgG3",23.71,66.81),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.MEAN, "IgG3",34.98,96.08),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.MEAN, "IgG3",46.82,121.56),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.MEAN, "IgG3",49.53,113.25),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.MEAN, "IgG3",51.83,138.41),


                    new ValueRanges(25,35,"turkjmedsci", CalculateType.MINMAX, "IgG3",19.8 ,75.),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.MINMAX, "IgG3",20.8,93.2),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.MINMAX, "IgG3",18.9,135.0),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.MINMAX, "IgG3",34.1,200.0),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.MINMAX, "IgG3",35.2,150.0),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.MINMAX, "IgG3",29.3,200.0),


                    new ValueRanges(25,35,"turkjmedsci", CalculateType.CI95, "IgG3",45.41,58.04),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.CI95, "IgG3",37.21,53.30),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.CI95, "IgG3",53.01,78.06),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.CI95, "IgG3",70.24,98.15),
                    new ValueRanges(144,191, "turkjmedsci",CalculateType.CI95, "IgG3",69.49,93.28),
                    new ValueRanges(192,216, "turkjmedsci",CalculateType.CI95, "IgG3",78.95,111.28),


                    new ValueRanges(25,35,"turkjmedsci", CalculateType.GEOMETRIC, "IgG4",6.99,24.07),
                    new ValueRanges(36,60, "turkjmedsci",CalculateType.GEOMETRIC, "IgG4",15.39,46.23),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.GEOMETRIC, "IgG4",16.28,62.38),
                    new ValueRanges(108,132, "turkjmedsci",CalculateType.GEOMETRIC, "IgG4",9.97,40.75),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.GEOMETRIC, "IgG4",14.30,61.97),
                    new ValueRanges(192,216, "turkjmedsci",CalculateType.GEOMETRIC, "IgG4",15.81,15.90),


                    new ValueRanges(25,35,"turkjmedsci", CalculateType.MEAN, "IgG4",9.83,26.91),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.MEAN, "IgG4",25.33,56.17),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.MEAN, "IgG4",27.89,74.99),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.MEAN, "IgG4",20.12,50.90),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.MEAN, "IgG4",22.78,56.24),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.MEAN, "IgG4",27.08,73.24),


                    new ValueRanges(25,35, "turkjmedsci",CalculateType.MINMAX, "IgG4",7.86,57.5),
                    new ValueRanges(36,60,"turkjmedsci",CalculateType.MINMAX, "IgG4",7.86,122.0),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.MINMAX, "IgG4",7.86,157.0),
                    new ValueRanges(108,132, "turkjmedsci",CalculateType.MINMAX, "IgG4",7.86,93.8),
                    new ValueRanges(144,191, "turkjmedsci",CalculateType.MINMAX, "IgG4",7.86,119.0),
                    new ValueRanges(192,216, "turkjmedsci",CalculateType.MINMAX, "IgG4",7.86,157.0),


                    new ValueRanges(25,35, "turkjmedsci",CalculateType.CI95, "IgG4",13.67,23.07),
                    new ValueRanges(36,60, "turkjmedsci",CalculateType.CI95, "IgG4",28.84,52.65),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.CI95, "IgG4",37.11,64.77),
                    new ValueRanges(108,132, "turkjmedsci",CalculateType.CI95, "IgG4",24.95,46.07),
                    new ValueRanges(144,191, "turkjmedsci",CalculateType.CI95, "IgG4",29.53,49.49),
                    new ValueRanges(192,216, "turkjmedsci",CalculateType.CI95, "IgG4",36.32,64.01),

                    new ValueRanges(0,0, "turkjmedsci",CalculateType.GEOMETRIC, "IgA",6.32,7.22),
                    new ValueRanges(1,3, "turkjmedsci",CalculateType.GEOMETRIC,"IgA",4.42,14.74),
                    new ValueRanges(4,6, "turkjmedsci",CalculateType.GEOMETRIC, "IgA",7.46,27.00),
                    new ValueRanges(7,12, "turkjmedsci",CalculateType.GEOMETRIC, "IgA",11.26,35.99),
                    new ValueRanges(13,24, "turkjmedsci",CalculateType.GEOMETRIC, "IgA",16.99,51.19),
                    new ValueRanges(25,35, "turkjmedsci",CalculateType.GEOMETRIC, "IgA",24.35,73.39),
                    new ValueRanges(36,60, "turkjmedsci",CalculateType.GEOMETRIC, "IgA",28.70,96.80),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.GEOMETRIC, "IgA",47.72,147.04),
                    new ValueRanges(108,132, "turkjmedsci",CalculateType.GEOMETRIC, "IgA",55.22,149.32),
                    new ValueRanges(144,191, "turkjmedsci",CalculateType.GEOMETRIC, "IgA",64.65,159.67),
                    new ValueRanges(192,216, "turkjmedsci",CalculateType.GEOMETRIC, "IgA",89.29,269.13),

                    new ValueRanges(0,0, "turkjmedsci",CalculateType.MEAN, "IgA",6.34,7.24),
                    new ValueRanges(1,3, "turkjmedsci",CalculateType.MEAN,"IgA",5.37,15.69),
                    new ValueRanges(4,6, "turkjmedsci",CalculateType.MEAN, "IgA",10.09,29.63),
                    new ValueRanges(7,12, "turkjmedsci",CalculateType.MEAN, "IgA",17.04,41.78),
                    new ValueRanges(13,24,"turkjmedsci", CalculateType.MEAN, "IgA",20.52,55.72),
                    new ValueRanges(25,35, "turkjmedsci",CalculateType.MEAN, "IgA",35.25,84.29),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.MEAN, "IgA",34.93,103.03),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.MEAN, "IgA",57.24,156.56),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.MEAN, "IgA",68.94,163.04),
                    new ValueRanges(144,191, "turkjmedsci",CalculateType.MEAN, "IgA",73.39,168.41),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.MEAN, "IgA",111.92,291.76),

                    new ValueRanges(0,0, "turkjmedsci",CalculateType.MINMAX, "IgA",6.67,8.75),
                    new ValueRanges(1,3,"turkjmedsci", CalculateType.MINMAX,"IgA",6.67,24.6),
                    new ValueRanges(4,6, "turkjmedsci",CalculateType.MINMAX, "IgA",6.67,53.0),
                    new ValueRanges(7,12,"turkjmedsci", CalculateType.MINMAX, "IgA",6.68,114.0),
                    new ValueRanges(13,24,"turkjmedsci", CalculateType.MINMAX, "IgA",13.1,103.0),
                    new ValueRanges(25,35,"turkjmedsci", CalculateType.MINMAX, "IgA",6.67,135.0),
                    new ValueRanges(36,60, "turkjmedsci",CalculateType.MINMAX, "IgA",35.7,192.0),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.MINMAX, "IgA",44.8,276.0),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.MINMAX, "IgA",32.6,262.0),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.MINMAX, "IgA",36.4,305.0),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.MINMAX, "IgA",46.3,385.0),

                    new ValueRanges(0,0, "turkjmedsci",CalculateType.CI95, "IgA",6.62,6.95),
                    new ValueRanges(1,3,"turkjmedsci", CalculateType.CI95,"IgA",8.57,12.49),
                    new ValueRanges(4,6,"turkjmedsci", CalculateType.CI95, "IgA",14.70,25.01),
                    new ValueRanges(7,12, "turkjmedsci",CalculateType.CI95, "IgA",21.06,37.77),
                    new ValueRanges(13,24, "turkjmedsci",CalculateType.CI95, "IgA",31.34,47.85),
                    new ValueRanges(25,35,"turkjmedsci", CalculateType.CI95, "IgA",46.05,71.38),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.CI95, "IgA",56.27,81.7),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.CI95, "IgA",88.36,125.45),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.CI95, "IgA",94.69,137.29),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.CI95, "IgA",99.29,172.11),
                    new ValueRanges(192,216,"turkjmedsci",CalculateType.CI95, "IgA",168.26,235.41),

                    new ValueRanges(0,0,"turkjmedsci", CalculateType.GEOMETRIC, "IgM",8.02,25.76),
                    new ValueRanges(1,3,"turkjmedsci", CalculateType.GEOMETRIC,"IgM",20.66,47.76),
                    new ValueRanges(4,6,"turkjmedsci", CalculateType.GEOMETRIC, "IgM",39.32,98.78),
                    new ValueRanges(7,12,"turkjmedsci", CalculateType.GEOMETRIC, "IgM",37.66,109.18),
                    new ValueRanges(13,24,"turkjmedsci", CalculateType.GEOMETRIC, "IgM",73.62,156.88),
                    new ValueRanges(25,35,"turkjmedsci", CalculateType.GEOMETRIC, "IgM",64.11,145.21),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.GEOMETRIC, "IgM",76.36,154.84),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.GEOMETRIC, "IgM",66.78,149.32),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.GEOMETRIC, "IgM",61.27,148.63),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.GEOMETRIC, "IgM",79.85,158.47),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.GEOMETRIC, "IgM",66.28,194.92),

                    new ValueRanges(0,0,"turkjmedsci", CalculateType.MEAN, "IgM",11.51,29.25),
                    new ValueRanges(1,3,"turkjmedsci", CalculateType.MEAN,"IgM",23.11,50.21),
                    new ValueRanges(4,6,"turkjmedsci", CalculateType.MEAN, "IgM",45.71,105.17),
                    new ValueRanges(7,12,"turkjmedsci", CalculateType.MEAN, "IgM",45.29,116.81),
                    new ValueRanges(13,24, "turkjmedsci",CalculateType.MEAN, "IgM",80.94,164.20),
                    new ValueRanges(25,35,"turkjmedsci", CalculateType.MEAN, "IgM",70.76,151.86),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.MEAN, "IgM",82.55,161.03),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.MEAN, "IgM",73.46,156.00),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.MEAN, "IgM",69.50,156.86),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.MEAN, "IgM",86.47,165.09),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.MEAN, "IgM",78.22,206.86),

                    new ValueRanges(0,0, "turkjmedsci",CalculateType.MINMAX, "IgM",5.1,50.9),
                    new ValueRanges(1,3,"turkjmedsci", CalculateType.MINMAX,"IgM",15.2,68.5),
                    new ValueRanges(4,6,"turkjmedsci", CalculateType.MINMAX, "IgM",26.9,130.0),
                    new ValueRanges(7,12,"turkjmedsci", CalculateType.MINMAX, "IgM",24.2,162.0),
                    new ValueRanges(13,24,"turkjmedsci", CalculateType.MINMAX, "IgM",38.6,195.0),
                    new ValueRanges(25,35,"turkjmedsci", CalculateType.MINMAX, "IgM",42.7,236.0),
                    new ValueRanges(36,60,"turkjmedsci", CalculateType.MINMAX, "IgM",58.7,198.0),
                    new ValueRanges(72,96,"turkjmedsci", CalculateType.MINMAX, "IgM",50.3,242.0),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.MINMAX, "IgM",37.4,213.0),
                    new ValueRanges(144,191,"turkjmedsci", CalculateType.MINMAX, "IgM",42.4,197.0),
                    new ValueRanges(192,216,"turkjmedsci", CalculateType.MINMAX, "IgM",60.7,323.0),

                    new ValueRanges(0,0, "turkjmedsci",CalculateType.CI95, "IgM",15.57,5.18),
                    new ValueRanges(1,3, "turkjmedsci",CalculateType.CI95,"IgM",31.60,41.72),
                    new ValueRanges(4,6,"turkjmedsci", CalculateType.CI95, "IgM",64.34,86.54),
                    new ValueRanges(7,12,"turkjmedsci", CalculateType.CI95, "IgM",67.7,94.41),
                    new ValueRanges(13,24,"turkjmedsci", CalculateType.CI95, "IgM",107.03,138.12),
                    new ValueRanges(25,35,"turkjmedsci", CalculateType.CI95, "IgM",96.17,126.46),
                    new ValueRanges(36,60, "turkjmedsci",CalculateType.CI95, "IgM",107.13,136.44),
                    new ValueRanges(72,96, "turkjmedsci",CalculateType.CI95, "IgM",99.32,130.14),
                    new ValueRanges(108,132,"turkjmedsci", CalculateType.CI95, "IgM",96.87,129.49),
                    new ValueRanges(144,191, "turkjmedsci",CalculateType.CI95, "IgM",111.1,140.46),
                    new ValueRanges(192,216, "turkjmedsci",CalculateType.CI95, "IgM",118.53,166.55)
                    );

            valueRangesRepository.saveAll(valueRangesList);



        }

    }
}
