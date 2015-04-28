//
//  RegisterView.h
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface RegisterView : UIView

@property (strong, nonatomic) IBOutlet UITextField *phoneTextfield;

@property (strong, nonatomic) IBOutlet UITextField *passwordTextField;

@property (strong, nonatomic) IBOutlet UITextField *confirmPasswordTextField;


@property (strong, nonatomic) IBOutlet UITextField *vertifyTextField;




@property (strong, nonatomic) IBOutlet UIButton *nextButton;




@property (strong, nonatomic) IBOutlet UIView *confirmPasswordView;



@property (strong, nonatomic) IBOutlet UIView *passwordView;


@property (strong, nonatomic) IBOutlet UIView *vertifyView;


@property (strong, nonatomic) IBOutlet UIButton *vertifyButton;

@property (strong, nonatomic) IBOutlet UIView *phoneView;


@property (strong, nonatomic) IBOutlet UIButton *backButton;


@property (strong, nonatomic) IBOutlet UIView *topView;


@end
