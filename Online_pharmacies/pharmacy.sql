/*
 Navicat Premium Data Transfer

 Source Server         : 本地连接mysql
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : localhost:3306
 Source Schema         : pharmacy

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 13/10/2024 13:34:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for drugdrugtype
-- ----------------------------
DROP TABLE IF EXISTS `drugdrugtype`;
CREATE TABLE `drugdrugtype`  (
  `ddt_id` int NOT NULL AUTO_INCREMENT,
  `medication_f_id` int NULL DEFAULT NULL,
  `type_f_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`ddt_id`) USING BTREE,
  INDEX `medication_id`(`medication_f_id` ASC) USING BTREE,
  INDEX `type_id`(`type_f_id` ASC) USING BTREE,
  CONSTRAINT `drugdrugtype_ibfk_1` FOREIGN KEY (`medication_f_id`) REFERENCES `medication` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `drugdrugtype_ibfk_2` FOREIGN KEY (`type_f_id`) REFERENCES `medicationtype` (`type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of drugdrugtype
-- ----------------------------
INSERT INTO `drugdrugtype` VALUES (1, 1, 2);
INSERT INTO `drugdrugtype` VALUES (2, 2, 2);
INSERT INTO `drugdrugtype` VALUES (3, 3, 1);
INSERT INTO `drugdrugtype` VALUES (4, 4, 1);
INSERT INTO `drugdrugtype` VALUES (5, 5, 4);
INSERT INTO `drugdrugtype` VALUES (6, 6, 3);
INSERT INTO `drugdrugtype` VALUES (7, 9, 6);
INSERT INTO `drugdrugtype` VALUES (8, 8, 8);
INSERT INTO `drugdrugtype` VALUES (9, 3, 4);
INSERT INTO `drugdrugtype` VALUES (15, 9, 3);

-- ----------------------------
-- Table structure for medication
-- ----------------------------
DROP TABLE IF EXISTS `medication`;
CREATE TABLE `medication`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '药品名称',
  `generic_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '通用名',
  `dosage_form` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '剂型（如片剂、胶囊、液体等）',
  `route_of_administration` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '给药途径（如口服、注射等）',
  `expiry_date` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '有效期',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `stock_quantity` int NULL DEFAULT 0 COMMENT '库存数量',
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '药品描述',
  `power` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '药品功能',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '药品图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of medication
-- ----------------------------
INSERT INTO `medication` VALUES (1, '六味地黄丸(水蜜丸)', '六味地黄丸', '片剂', '口服', '48月', 13.50, 147, '熟地黄、酒萸肉、牡丹皮、山药、茯苓、泽泻。辅料为蜂蜜。', '滋阴补肾。用于肾阴亏损，头晕耳鸣，腰膝酸软，骨蒸潮热，盗汗遗精', '2024-09-05 20:31:43', '2024-10-11 00:22:41', '六味地黄丸.jpg');
INSERT INTO `medication` VALUES (2, '金水宝胶囊(金水宝)', '金水宝胶囊', '片剂', '口服', '36月', 64.50, 92, '发酵虫草菌粉', '补益肺肾两虚，精气不足，久咳虚喘，神疲乏力，不寐健忘，腰膝酸软，月经不调，阳痿早泄；慢性支气管炎见上述证候者', '2024-09-05 20:37:46', '2024-10-12 20:41:06', '金水宝胶囊.jpg');
INSERT INTO `medication` VALUES (3, '感冒灵颗粒(999)', '感冒灵颗粒', '颗粒', '开水冲服', '24月', 29.80, 130, '三叉苦、金盏银盘、野菊花、岗梅、咖啡因、对乙酰氨基酚、马来酸氯苯那敏、薄荷素油。辅料为蔗糖', '感冒引起的头痛,发热,鼻塞,流涕,咽痛等', '2024-09-10 22:19:07', '2024-10-11 19:48:52', '感冒灵.jpg');
INSERT INTO `medication` VALUES (4, '抗病毒颗粒(丽珠)', '抗病毒颗粒', '颗粒', '开水冲服', '24月', 38.50, 10, '板蓝根、连翘、石膏、如母、芦根、地黄、广藿香、石菖蒲、郁金', '清热祛湿，凉血解毒。用于风热感冒，上呼吸道感染，流感', '2024-09-10 22:20:46', '2024-10-12 20:42:04', '抗病毒颗粒.jpg');
INSERT INTO `medication` VALUES (5, '龙牡壮骨颗粒(龙牡)', '龙牡壮骨颗粒', '颗粒', '开水冲服', '36月', 74.50, 70, '党参、黄芪、山麦冬、醋龟甲、炒白术、山药、醋南五味子、龙骨、煅牡蛎、茯苓、大枣、甘草、乳酸钙、炒鸡内金、维生素D2、葡萄糖酸钙。辅料为蔗糖、菠萝萃取液', '强筋壮骨，和胃健脾。用于治疗和预防小儿佝偻病、软骨病；对小儿多汗、夜惊、食欲不振、消化不良、发育迟缓也有治疗作用', '2024-09-10 23:26:12', '2024-10-11 19:48:52', '龙牡壮骨颗粒.jpg');
INSERT INTO `medication` VALUES (6, '逍遥丸(九芝堂)', '逍遥丸', '栓剂', '口服', '36月', 24.80, 0, '柴胡、当归、白芍、炒白术、茯苓、炙甘草、薄荷。辅料为生姜、饴糖', '疏肝健脾，养血调经。用于肝郁脾虚所致的郁闷不舒、胸胁胀痛、头晕目眩、食欲减退、月经不调', '2024-09-10 23:27:48', '2024-10-06 21:45:32', '逍遥丸.jpg');
INSERT INTO `medication` VALUES (8, '参苓白术散(同仁堂)', '参苓白术散', '颗粒', '口服', '48月', 35.70, 500, '白扁豆、白术、茯苓、甘草、桔梗、莲子、人参、砂仁、山药、薏苡仁。', '白扁豆、白术、茯苓、甘草、桔梗、莲子、人参、砂仁、山药、薏苡仁。', '2024-10-09 20:52:07', '2024-10-09 20:52:07', 'senling.png');
INSERT INTO `medication` VALUES (9, '清血八味片(蒙奇)', '清血八味片', '片剂', '口服', '36月', 375.00, 598, '寒水石（凉制）、紫草、土木香、人工牛黄、栀子、瞿麦、石膏、甘草；辅料为淀粉', '清讧血，用于血热头痛，口渴目赤，中暑', '2024-10-09 22:55:51', '2024-10-11 19:48:52', 'qingxuebawei.jpg');

-- ----------------------------
-- Table structure for medicationtype
-- ----------------------------
DROP TABLE IF EXISTS `medicationtype`;
CREATE TABLE `medicationtype`  (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of medicationtype
-- ----------------------------
INSERT INTO `medicationtype` VALUES (1, '日常用药', '生活常见、常用的药品');
INSERT INTO `medicationtype` VALUES (2, '男科用药', NULL);
INSERT INTO `medicationtype` VALUES (3, '妇科用药', NULL);
INSERT INTO `medicationtype` VALUES (4, '儿科用药', NULL);
INSERT INTO `medicationtype` VALUES (5, '滋补保健', NULL);
INSERT INTO `medicationtype` VALUES (6, '心血管科', NULL);
INSERT INTO `medicationtype` VALUES (7, '糖尿病科', NULL);
INSERT INTO `medicationtype` VALUES (8, '肝胆科药', NULL);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `menuCode` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单编码',
  `menuName` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单名字',
  `menuLevel` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单级别',
  `menuParentCode` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单的父code',
  `menuClick` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '点击触发的函数',
  `menuRight` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '权限 0为超级管理员，1为管理员',
  `menuComponent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `menuIcon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '001', '管理员管理', '1', NULL, 'Admin', '0', 'adminmanage/AdminManage.vue', 'el-icon-s-custom');
INSERT INTO `menu` VALUES (2, '002', '用户管理', '1', NULL, 'User', '0,1', 'usermanage/UserManage.vue', 'el-icon-user-solid');
INSERT INTO `menu` VALUES (3, '003', '药品管理', '1', NULL, 'Medication', '0,1', 'medication/MedicationManage.vue', 'el-icon-s-goods');
INSERT INTO `menu` VALUES (4, '004', '分类管理', '1', NULL, 'MedicationType', '0,1', 'typemanage/TypeManage.vue', 'el-icon-s-management');
INSERT INTO `menu` VALUES (5, '005', '菜单管理', '1', NULL, 'Menu', '0', 'menumanage/MenuManage.vue', 'el-icon-menu');
INSERT INTO `menu` VALUES (7, '006', '订单管理', '1', NULL, 'Orders', '0,1', 'ordersmanage/OrdersManage.vue', 'el-icon-s-order');
INSERT INTO `menu` VALUES (8, '007', '药品归类', '1', NULL, 'Classify', '0,1', 'classify/Classify.vue', 'el-icon-s-management');

-- ----------------------------
-- Table structure for order_items
-- ----------------------------
DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items`  (
  `order_item_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `medication_id` int NOT NULL,
  `quantity` int NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `total_price` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`order_item_id`) USING BTREE,
  INDEX `order_id`(`order_id` ASC) USING BTREE,
  INDEX `medication_id`(`medication_id` ASC) USING BTREE,
  CONSTRAINT `order_items_ibfk_3` FOREIGN KEY (`medication_id`) REFERENCES `medication` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order_items
-- ----------------------------
INSERT INTO `order_items` VALUES (1, 2, 2, 2, 64.50, 129.00);
INSERT INTO `order_items` VALUES (2, 3, 6, 2, 24.80, 49.60);
INSERT INTO `order_items` VALUES (3, 4, 1, 3, 13.50, 40.50);
INSERT INTO `order_items` VALUES (4, 5, 4, 3, 38.50, 115.50);
INSERT INTO `order_items` VALUES (5, 6, 5, 2, 74.50, 149.00);
INSERT INTO `order_items` VALUES (6, 7, 4, 1, 38.50, 38.50);
INSERT INTO `order_items` VALUES (7, 7, 2, 2, 64.50, 129.00);
INSERT INTO `order_items` VALUES (8, 10, 4, 2, 38.50, 77.00);
INSERT INTO `order_items` VALUES (9, 10, 5, 3, 74.50, 223.50);
INSERT INTO `order_items` VALUES (10, 11, 1, 1, 13.50, 13.50);
INSERT INTO `order_items` VALUES (11, 11, 2, 1, 64.50, 64.50);
INSERT INTO `order_items` VALUES (12, 11, 3, 1, 29.80, 29.80);
INSERT INTO `order_items` VALUES (13, 12, 3, 1, 29.80, 29.80);
INSERT INTO `order_items` VALUES (16, 14, 4, 1, 38.50, 38.50);
INSERT INTO `order_items` VALUES (17, 14, 3, 2, 29.80, 59.60);
INSERT INTO `order_items` VALUES (18, 20, 3, 2, 29.80, 59.60);
INSERT INTO `order_items` VALUES (20, 22, 2, 200, 64.50, 12900.00);
INSERT INTO `order_items` VALUES (21, 22, 3, 2, 29.80, 59.60);
INSERT INTO `order_items` VALUES (22, 22, 9, 2, 375.00, 750.00);
INSERT INTO `order_items` VALUES (23, 23, 5, 80, 74.50, 5960.00);
INSERT INTO `order_items` VALUES (24, 24, 5, 79, 74.50, 5885.50);
INSERT INTO `order_items` VALUES (25, 25, 5, 80, 74.50, 5960.00);
INSERT INTO `order_items` VALUES (26, 26, 3, 33, 29.80, 983.40);
INSERT INTO `order_items` VALUES (27, 27, 3, 400, 29.80, 11920.00);
INSERT INTO `order_items` VALUES (28, 27, 5, 2, 74.50, 149.00);
INSERT INTO `order_items` VALUES (29, 27, 9, 2, 375.00, 750.00);
INSERT INTO `order_items` VALUES (30, 28, 2, 1, 64.50, 64.50);
INSERT INTO `order_items` VALUES (31, 29, 2, 3, 64.50, 193.50);
INSERT INTO `order_items` VALUES (32, 30, 4, 1, 38.50, 38.50);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `order_date` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `total_price` decimal(10, 2) NOT NULL,
  `useraddress_id` int NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `useraddress_id`(`useraddress_id` ASC) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`useraddress_id`) REFERENCES `user_address` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (2, 1, '2024-10-06 15:01:45', '待发货', 129.00, 1);
INSERT INTO `orders` VALUES (3, 16, '2024-10-06 15:14:31', '待收货', 49.60, 12);
INSERT INTO `orders` VALUES (4, 16, '2024-10-06 15:18:14', '待评价', 40.50, 12);
INSERT INTO `orders` VALUES (5, 16, '2024-10-06 15:20:34', '待发货', 115.50, 12);
INSERT INTO `orders` VALUES (6, 16, '2024-10-06 15:21:23', '待评价', 149.00, 12);
INSERT INTO `orders` VALUES (7, 16, '2024-10-06 15:22:37', '待评价', 167.50, 12);
INSERT INTO `orders` VALUES (10, 16, '2024-10-07 16:45:56', '待发货', 300.50, 12);
INSERT INTO `orders` VALUES (11, 16, '2024-10-07 19:27:22', '待发货', 107.80, 12);
INSERT INTO `orders` VALUES (12, 16, '2024-10-07 19:45:43', '待发货', 29.80, 12);
INSERT INTO `orders` VALUES (14, 1, '2024-10-07 20:37:11', '待付款', 98.10, 2);
INSERT INTO `orders` VALUES (20, 1, '2024-10-07 22:52:25', '待发货', 59.60, 1);
INSERT INTO `orders` VALUES (22, 9, '2024-10-11 00:07:04', '待评价', 13709.60, 7);
INSERT INTO `orders` VALUES (23, 9, '2024-10-11 00:10:05', '待发货', 5960.00, 4);
INSERT INTO `orders` VALUES (24, 9, '2024-10-11 00:14:48', '待发货', 5885.50, 4);
INSERT INTO `orders` VALUES (25, 9, '2024-10-11 00:21:07', '待发货', 5960.00, 4);
INSERT INTO `orders` VALUES (26, 9, '2024-10-11 00:23:07', '待发货', 983.40, 7);
INSERT INTO `orders` VALUES (27, 1, '2024-10-11 19:48:52', '待发货', 12819.00, 1);
INSERT INTO `orders` VALUES (28, 1, '2024-10-12 20:33:11', '待付款', 64.50, 1);
INSERT INTO `orders` VALUES (29, 1, '2024-10-12 20:41:06', '待发货', 193.50, 1);
INSERT INTO `orders` VALUES (30, 1, '2024-10-12 20:42:04', '待付款', 38.50, 1);

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart`  (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `medication_id` int NOT NULL,
  `medication_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `medication_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `quantity` int NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `total_price` decimal(10, 2) NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cart_id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id` ASC, `medication_id` ASC) USING BTREE,
  INDEX `medication_id`(`medication_id` ASC) USING BTREE,
  CONSTRAINT `shoppingcart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `shoppingcart_ibfk_2` FOREIGN KEY (`medication_id`) REFERENCES `medication` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userno` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '账号',
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '名字',
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `age` int NULL DEFAULT NULL,
  `sex` int NULL DEFAULT NULL COMMENT '性别, 0为女, 1为男',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `role_id` int NULL DEFAULT NULL COMMENT '角色 0超级管理员，1管理员，2普通账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'adminsa', '仙风道骨', '111111', 36, 1, '13926309210', 0);
INSERT INTO `user` VALUES (2, 'admin1', '管理员1', '123456', 23, 1, '13926309211', 1);
INSERT INTO `user` VALUES (3, 'admin2', '管理员2', '123456', 20, 0, '13926309212', 1);
INSERT INTO `user` VALUES (4, 'mvfvuo', '高秀英', '16383338', 22, 0, '16123163813', 2);
INSERT INTO `user` VALUES (5, 'vhsjro', '金致远', '84618931', 35, 0, '18284922716', 2);
INSERT INTO `user` VALUES (6, 'surecv', '王秀英', '13512382', 30, 0, '16618585685', 2);
INSERT INTO `user` VALUES (8, 'wniktt', '任晓明', '90747661', 38, 1, '10697677971', 2);
INSERT INTO `user` VALUES (9, 'yefanxiaoma', '富哥', '123456', 36, 1, '13926309213', 2);
INSERT INTO `user` VALUES (11, 'abcdefg', '123', '123456', 40, 1, '13169391831', 2);
INSERT INTO `user` VALUES (16, 'yefan', 'x', '111111', 20, 1, '13169391833', 2);
INSERT INTO `user` VALUES (18, 'yefan1', '叶凡1', '111111', 22, 1, '13926309219', 1);
INSERT INTO `user` VALUES (19, 'asdasd', '游客1', '111111', 69, 1, '13921109766', 2);
INSERT INTO `user` VALUES (20, 'tianjiang', '天降之物', '111111', 30, 0, '13769391835', 2);
INSERT INTO `user` VALUES (21, 'tt', '添加', '111111', 12, 0, '13969391835', 2);

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收货人姓名',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省份',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '城市',
  `district` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '区县',
  `detail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '详细地址',
  `user_id` int NOT NULL COMMENT '外键',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `user_address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_address
-- ----------------------------
INSERT INTO `user_address` VALUES (1, '仙风道骨', '13926309210', '广东省', '阳江市', '阳春市', '垌心街13号', 1, '2024-09-24 22:29:36');
INSERT INTO `user_address` VALUES (2, '叶凡', '13926309211', '广东省', '广州市', '越秀区', '广州塔261号', 1, '2024-09-24 23:25:32');
INSERT INTO `user_address` VALUES (4, '帆帆', '13926309211', '浙江省', '嘉兴市', '嘉善县', '陆家嘴金融区滨江大道旁', 9, '2024-09-25 22:29:29');
INSERT INTO `user_address` VALUES (7, '帆帆', '13926309211', '广东省', '广州市', '越秀区', '广州塔261号', 9, '2024-09-25 22:37:07');
INSERT INTO `user_address` VALUES (12, '王', '13926309213', '广东省', '广州市', '越秀区', '广州塔261号', 16, '2024-10-05 19:18:20');
INSERT INTO `user_address` VALUES (13, '室委书记', '13169391836', '北京市', '市辖区', '东城区', '北京市西城区西长安街北侧', 1, '2024-10-12 20:31:40');

-- ----------------------------
-- Triggers structure for table order_items
-- ----------------------------
DROP TRIGGER IF EXISTS `update_medication_stock_after_insert`;
delimiter ;;
CREATE TRIGGER `update_medication_stock_after_insert` AFTER INSERT ON `order_items` FOR EACH ROW BEGIN
    UPDATE medication
    SET stock_quantity = stock_quantity - NEW.quantity
    WHERE id = NEW.medication_id;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
